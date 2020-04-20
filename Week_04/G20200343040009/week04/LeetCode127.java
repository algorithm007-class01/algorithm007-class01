

import java.util.*;

public class LeetCode127 {
    /**
     * 1. 将wordList所有单词做预处理，转换成通用状态，并记录在字典中，key是通用状态，值是所有具有通用形式的word   hot、hit的通用状态为h*t
     * 2. 将单词和单词所在层级以键值对形式放入队列中
     * 3. 防止出现环，需要记录每个单词是否被访问过
     * 4. 取队列第一个元素，记为currWord
     * 5. 找到currWord所有通用状态
     *
     * @param beginWord root结点
     * @param endWord   end结点
     * @param wordList  中间结点
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        // 每个单词长度相同
        int l = beginWord.length();
        // 预处理，将所有单词做成通配形式的
        HashMap<String, List<String>> allComboDict = new HashMap<>();

        wordList.forEach(word -> {
            for (int i = 0; i < l; i++) {
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, l);
                // 获取这个通配符相对应的单词集合，无该集合则新建
                List<String> trans = allComboDict.getOrDefault(newWord, new ArrayList<>());
                // 将单词加入该list
                trans.add(word);
                // 并将其加入到字典中
                allComboDict.put(newWord, trans);
            }
        });
        // 广度优先遍历队列
        Queue<Pair<String, Integer>> q = new LinkedList<>();
        // 记录单词访问记录
        HashMap<String, Boolean> hasVistedList = new HashMap<>();
        // 将beginWord作为第一个节点加入队列，深度为1，并标记已被访问
        q.add(new Pair<>(beginWord, 1));
        hasVistedList.put(beginWord, true);
        // 广度优先遍历，取出队列中元素进行操作
        while (!q.isEmpty()) {
            // 获取队列第一个节点
            Pair<String, Integer> node = q.remove();
            // 当前节点对应的<单词，层级>
            String currWord = node.getKey();
            int level = node.getValue();

            for (int i = 0; i < l; i++) {
                // 从当前单词，得到l个通配词
                String currComboWord = currWord.substring(0, i) + '*' + currWord.substring(i + 1, l);
                // 拿出这个通配词的单词集合（即当前词语能够转换得到哪些单词）
                List<String> currComboWordList = allComboDict.getOrDefault(currComboWord, new ArrayList<>());
                // 遍历其中是否包含目标单词
                for (String word : currComboWordList) {
                    if (word.equals(endWord)) {
                        // 包含目标单词，说明当前单词能一次转换到目标单词，经历的步骤数是当前单词的层级 + 1
                        return level + 1;
                    }
                    // 否则，将得到下一个未被访问的单词
                    if (!hasVistedList.containsKey(word)) {
                        // 把这个单词加入到队列中
                        q.add(new Pair<>(word, level + 1));
                        // 标记它已被访问
                        hasVistedList.put(word, true);
                    }

                }
            }
        }
        return 0;
    }
}
