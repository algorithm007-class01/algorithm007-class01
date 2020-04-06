import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=126 lang=java
 *
 * [126] 单词接龙 II
 *
 * https://leetcode-cn.com/problems/word-ladder-ii/description/
 *
 * algorithms
 * Hard (32.08%)
 * Likes:    136
 * Dislikes: 0
 * Total Accepted:    8.1K
 * Total Submissions: 25.6K
 * Testcase Example:  '"hit"\n"cog"\n["hot","dot","dog","lot","log","cog"]'
 *
 * 给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord
 * 的最短转换序列。转换需遵循如下规则：
 * 
 * 
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 
 * 
 * 说明:
 * 
 * 
 * 如果不存在这样的转换序列，返回一个空列表。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 
 * 
 * 示例 1:
 * 
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 
 * 输出:
 * [
 * ⁠ ["hit","hot","dot","dog","cog"],
 * ["hit","hot","lot","log","cog"]
 * ]
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * 
 * 输出: []
 * 
 * 解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。
 * 
 */

// @lc code=start
class Solution {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
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
            return new ArrayList<List<String>>(0);
        }

        Queue<List<String>> queue = new LinkedList<>();
        queue.add(Arrays.asList(beginWord));

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        List<List<String>> found = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 将当前层级的下一层节点放入“nextLevelWords”中
            // 然后在进入下一层节点时，将“nextLevelWords”中的所有元素放入“visited”中
            Set<String> nextLevelWords = new HashSet<>();
            for (int i = 0; i < size; i++) {
                List<String> currentPath = queue.poll();
                String current = currentPath.get(currentPath.size() - 1);
                if (current.equals(endWord)) {
                    found.add(currentPath);
                    continue;
                }
                if (found.size() > 0) {
                    continue;
                }

                for (int j = 0; j < charCount; j++) {
                    String newWord = current.substring(0, j) + "*" + current.substring(j + 1);
                    List<String> comboWords = allComboDict.get(newWord);
                    if (null == comboWords) {
                        continue;
                    }

                    for (int k = 0; k < comboWords.size(); k++) {
                        String next = comboWords.get(k);
                        // “visited”中存放的是“next”所在层级之上所有层级的元素
                        // 如果“next”在“visited”中，说明在更早的层级中已经使用过该单词
                        // 同一个单词在不同的层级出现，层级越小，从起点到达终点的距离就越短。
                        // 所以应当跳过“next”。
                        if (visited.contains(next)) {
                            continue;
                        }

                        List<String> nextPath = new ArrayList<>(currentPath.size() + 1);
                        nextPath.addAll(currentPath);
                        nextPath.add(next);
                        queue.offer(nextPath);

                        nextLevelWords.add(next);
                    }
                }
            }

            if (found.size() > 0) {
                return found;
            }

            visited.addAll(nextLevelWords);
        }

        return found;
    }
}
// @lc code=end

