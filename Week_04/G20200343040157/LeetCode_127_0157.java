//给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
// 
//
// 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典中的单词。 
// 
//
// 说明: 
//
// 
// 如果不存在这样的转换序列，返回 0。 
// 所有单词具有相同的长度。 
// 所有单词只由小写字母组成。 
// 字典中不存在重复的单词。 
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。 
// 
//
// 示例 1: 
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出: 5
//
//解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//     返回它的长度 5。
// 
//
// 示例 2: 
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: 0
//
//解释: endWord "cog" 不在字典中，所以无法进行转换。 
// Related Topics 广度优先搜索


import java.util.HashSet;
import java.util.List;
import java.util.Queue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 广度有限搜索，wordList限定范围。广度有限搜索中，本身存在一个 visited，防止重复访问，也是限制范围的。
        // 二者可以合并，只有在 wordList 里才算有效的子节点，且访问一次后删掉。！！！！删除会存在遍历，因此还是用两个Set

        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        if (!wordSet.contains(endWord)){
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 0;
        while (!queue.isEmpty()){
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                visited.add(poll);
                if (poll.equals(endWord)){
                    return level;
                }
                Set<String> nextWords = getValidNextWord1(poll,wordSet,visited);
                queue.addAll(nextWords);
            }
        }
        return 0;
    }

    // 一种思路是 pool 不断变换，然后筛选在wordList里的，如果pool长度是m，wordList长度是n，则复杂度是 25^m
    // 另一种思路是直接看wordList里的是否满足条件，复杂度是 n*m，用思路二
    private Set<String> getValidNextWord1(String poll, Set<String> wordSet, Set<String> visited) {
        Set<String> result = new HashSet<>();
        for (String word : wordSet) {
            if (isNextWord(word,poll)){
                result.add(word);
            }
        }
        wordSet.removeAll(result);
        return result;
    }

    // 单次长度相同
    private boolean isNextWord(String word, String poll) {
        int diffCount = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != poll.charAt(i)){
                diffCount++;
            }
        }
        return diffCount == 1;
    }

    private Set<String> getValidNextWord(String poll, Set<String> wordSet, Set<String> visited) {
        Set<String> result = new HashSet<>();
        char[] chars = poll.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char oldChar = chars[i];
            for (int j = 'a'; j <= 'z'; j++){
                chars[i] = (char)j;
                String s = new String(chars);
                if (wordSet.contains(s) && !visited.contains(s)){
                    result.add(s);
                }
            }
            chars[i] = oldChar;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
