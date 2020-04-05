//给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
// 每次转换只能改变一个字母。
// 转换过程中的中间单词必须是字典中的单词。
// 说明:
// 如果不存在这样的转换序列，返回 0。
// 所有单词具有相同的长度。
// 所有单词只由小写字母组成。
// 字典中不存在重复的单词。
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
//
// Related Topics 广度优先搜索


//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {

    /**
     * 最重要的步骤是找出只差一个字母的多个单词，即从当前单词一步能得到哪些单词。
     * 为了快速的找到这些相邻节点，我们对给定的 wordList 做一个预处理，将单词中的某个字母用 * 代替
     * 这个预处理帮我们构造了一个单词变换的通用状态。
     *
     * 我们使用一个Map来存储，键：通用状态；值：能得到这个通用状态的所有单词
     * 例如：Dog ----> D*g <---- Dig，Dog 和 Dig 都指向了一个通用状态 D*g。即键D*g对应的值为[Dog,Dig]
     *
     * 这步预处理找出了单词表中所有单词改变某个字母后的通用状态，并帮助我们更方便也更快的找到相邻节点。
     * 否则，对于每个单词我们需要遍历整个字母表查看是否存在一个单词与它相差一个字母，这将花费很多时间。
     * 预处理操作在广度优先搜索之前高效的建立了邻接表。
     *
     * 例如，在广搜时我们需要访问 Dug 的所有邻接点，也就是想知道由Dug能变换到字典中哪些单词
     * 我们可以先生成 Dug 的所有通用状态：以通用状态为键去获取值就可得到结果
     * Dug => *ug
     * Dug => D*g
     * Dug => Du*
     * 第二个变换 D*g 可以同时映射到 Dog 或者 Dig，因为他们都有相同的通用状态。拥有相同的通用状态意味着两个单词只相差一个字母，他们的节点是相连的。
     *
     */

    /**
     * 广度优先遍历(可认为是寻找全局最优解)
     * 1. 对给定的 wordList 做预处理，找出所有的通用状态。将通用状态记录在字典中，键是通用状态，值是所有具有通用状态的单词。
     * 2. 将键值对 <beginWord，1> 放入队列中，1 代表节点的层次。我们需要返回 endWord 的层次也就是从 beginWord 出发的最短距离。
     * 3. 为了防止出现环，使用访问数组记录当前单词已访问过。
     * 4. 当队列中有元素的时候，取出第一个元素，记为 current_word。
     * 5. 找到 current_word 的所有通用状态，并根据这些通用状态得到其对应的单词列表w1，w2，即从currWord能达到给定字典中的list中的w1和w2
     * 6. w1和w2都和 current_word 相连，因此将他们加入到队列中。
     * 7. 对于新获得的所有单词，向队列中加入元素 (word, level + 1) 其中 level 是 current_word 的层次。
     * 8. 最终当你到达期望的单词，对应的层次就是最短变换序列的长度
     * 相当于要从1得到9，发现1直接到达2和3，再操作2得到4和5，再操作3得到6和7，再操作4得到8和9，达到目标
     * 也就是一个广度优先遍历，因此需要借助 [队列]，且要避免重复遍历
     */
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 给定单词列表中不包括endword，直接返回
        if (!wordList.contains(endWord)) {
            return 0;
        }
        // 题目说明，每个单词长度相同
        int len = beginWord.length();
        // 处理给出的单词字典，转换为全部的通用状态及每个通配词映射的单词集合
        HashMap<String, ArrayList<String>> allComboDict = new HashMap<>();
        // lambda表达式遍历，currWord是当前正在遍历的单词
        wordList.forEach(curWord -> {
            // 每个单词能得到len种通配词(每个位置字符都可变为*)
            for (int i = 0; i < len; i++) {
                // 得到通配词
                String comboWord = curWord.substring(0, i) + "*" + curWord.substring(i + 1, len);
                // 从通配字典全集中拿到这个通配词对应的单词集合，如果是空(第一次得到通配词时)就创建一个新的
                ArrayList<String> comboWordList = allComboDict.getOrDefault(comboWord, new ArrayList<>());
                // 把当前这个单词加进去，因此从这个单词得到了这个通配词
                comboWordList.add(curWord);
                // 更新一个通配字典全集中这个通配词对应的单词集合
                allComboDict.put(comboWord, comboWordList);
            }
        });
        // 广度优先遍历队列
        // LinkedList implements Deque extends Queue
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        // 记录已遍历过的单词,为什么不用List，因为之后判断节点是否已遍历过时，ArrayList的contains方法太低效了，它的底层是数组，或者直接用TreeSet也可以
        // ArrayList<String> hasVistedList = new ArrayList<>();
        HashMap<String, Boolean> hasVistedList = new HashMap<>();
        // 开始词作为第一个节点加入队列,深度level是1，标记其已访问
        queue.add(new Pair<>(beginWord, 1));
        // hasVistedList.add(beginWord);
        hasVistedList.put(beginWord, true);
        // 广度优先遍历，逐个取出队列中元素进行操作
        while (!queue.isEmpty()) {
            // 队列第一个节点
            Pair<String, Integer> node = queue.remove();
            // 当前节点对应的<单词，层级>
            String currWord = node.getKey();
            int level = node.getValue();
            for (int i = 0; i < len; i++) {
                // 从当前单词，得到len个通配词
                String currComboWord = currWord.substring(0, i) + "*" + currWord.substring(i + 1, len);
                // 拿到这个通配词映射的单词集合(也就是从当前单词一次转换能得到哪些单词)
                ArrayList<String> currComboWordList = allComboDict.getOrDefault(currComboWord, new ArrayList<>());
                // 遍历其中是否包含目标单词
                for (String word : currComboWordList) {
                    // 包含目标单词，说明当前单词能一次转换到目标单词，经历的步骤数是当前单词的层级 + 1
                    if (word.equals(endWord)) {
                        return level + 1;
                    }

                    // 否则，当前单词能得到这个单词，如果它还没被访问过
                    // if (!hasVistedList.contains(word)) {
                    // HashMap.containsKey方法效率远高于ArrayList.contains
                    if (!hasVistedList.containsKey(word)) {
                        // 把这个单词加入到队列中
                        queue.add(new Pair<>(word, level + 1));
                        // 标记它为已访问
                        // hasVistedList.add(word);
                        hasVistedList.put(word, true);
                    }
                }
            }
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
