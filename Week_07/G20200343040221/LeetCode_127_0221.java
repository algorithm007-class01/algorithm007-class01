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

package leetcode.editor.cn;

import java.util.*;

public class WordLadder_127 {

//    public static void main(String[] args) {
//        Solution solution = new WordLadder_127().new Solution();
//        System.out.println(solution.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log")));
//    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private final char A = 'a';
    private final char Z = 'z';

    // 双向BFS
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        final Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Set<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);

        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);

        Set<String> visited = new HashSet<>();

        int step = 1;
        while (!beginSet.isEmpty() || !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size() || beginSet.size() == 0) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            Set<String> nextLevelSet = new HashSet<>();
            for (String word : beginSet) {
                char[] chars = word.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char oldChar = chars[i];
                    for (char letter = A; letter <= Z; letter++) {
                        if (letter != oldChar) {
                            chars[i] = letter;

                            String newWord = String.valueOf(chars);
                            if (endSet.contains(newWord)) {
                                return step + 1;
                            }

                            if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                                nextLevelSet.add(newWord);
                                visited.add(newWord);
                            }
                        }
                    }
                    chars[i] = oldChar;
                }
            }

            beginSet = nextLevelSet;
            step += 1;
        }

        return 0;
    }

    // BFS
    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        final Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int step = 0;
        while (!queue.isEmpty()) {
            step += 1;

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (word.equals(endWord)) {
                    return step;
                }

                char[] chars = word.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char oldChar = chars[j];
                    for (char letter = A; letter <= Z; letter++) {
                        if (letter != oldChar) {
                            chars[j] = letter;

                            String nextWord = String.valueOf(chars);
                            if (wordSet.contains(nextWord) && !visited.contains(nextWord)) {
                                queue.add(nextWord);
                                visited.add(nextWord);
                            }
                        }
                    }
                    chars[j] = oldChar;
                }
            }
        }

        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
  