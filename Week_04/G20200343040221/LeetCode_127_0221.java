import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=127 lang=java
 *
 * [127] 单词接龙
 *
 * https://leetcode-cn.com/problems/word-ladder/description/
 *
 * algorithms
 * Medium (40.56%)
 * Likes:    261
 * Dislikes: 0
 * Total Accepted:    30.2K
 * Total Submissions: 73.9K
 * Testcase Example:  '"hit"\n"cog"\n["hot","dot","dog","lot","log","cog"]'
 *
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord
 * 的最短转换序列的长度。转换需遵循如下规则：
 * 
 * 
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 
 * 
 * 说明:
 * 
 * 
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 
 * 
 * 示例 1:
 * 
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 
 * 输出: 5
 * 
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * ⁠    返回它的长度 5。
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * 
 * 输出: 0
 * 
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 * 
 */

// @lc code=start
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        boolean containsEndWord = false;
        int charCount = beginWord.length();
        Map<String, List<String>> allComboDict = new HashMap<>();
        for (int i = 0; i < wordList.size(); i++) {
            String word = wordList.get(i);
            if (endWord.equals(word)) {
                containsEndWord = true;
            }

            for (int j = 0; j < charCount; j++) {
                String newWord = word.substring(0, j) + "*" + word.substring(j + 1);
                List<String> comboWords = allComboDict.get(newWord);
                if (null == comboWords) {
                    comboWords = new ArrayList<>();
                    allComboDict.put(newWord, comboWords);
                }
                comboWords.add(word);
            }
        }

        if (!containsEndWord) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int deep = 0;
        while (!queue.isEmpty()) {
            deep++;

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (current.equals(endWord)) {
                    return deep;
                }

                for (int j = 0; j < charCount; j++) {
                    String newWord = current.substring(0, j) + "*" + current.substring(j + 1);
                    List<String> comboWords = allComboDict.get(newWord);
                    if (null == comboWords) {
                        continue;
                    }

                    for (int k = 0; k < comboWords.size(); k++) {
                        String next = comboWords.get(k);
                        if (!visited.contains(next)) {
                            queue.offer(next);
                            visited.add(next);
                        }
                    }
                }
            }
        }

        return 0;
    }
}
// @lc code=end

