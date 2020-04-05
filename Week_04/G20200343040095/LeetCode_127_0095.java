/*
 * @lc app=leetcode.cn id=127 lang=java
 *
 * [127] 单词接龙
 */

// @lc code=start
import javafx.util.Pair;
import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int len = beginWord.length();

        HashMap<String, ArrayList<String>> allCombDic = new HashMap<>();

        wordList.forEach(word -> {
            for (int i = 0; i < len; i++) {
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1, len);
                ArrayList<String> trans = allCombDic.getOrDefault(newWord, new ArrayList<>());
                trans.add(word);
                allCombDic.put(newWord, trans);
            }
        });

        Queue<Pair<String, Integer>> queue = new LinkedList<Pair<String, Integer>>();
        queue.add(new Pair(beginWord, 1));

        HashMap<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);

        while (!queue.isEmpty()) {
            Pair<String, Integer> node = queue.remove();
            String word = node.getKey();
            int level = node.getValue();

            for (int i = 0; i < len; i++) {
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1, len);

                for (String adjWord : allCombDic.getOrDefault(newWord, new ArrayList<>())) {
                    if (adjWord.equals(endWord)) {
                        return level + 1;
                    }

                    if (!visited.containsKey(adjWord)) {
                        visited.put(adjWord, true);
                        queue.add(new Pair(adjWord, level + 1));
                    }
                }
            }
        }

        return 0;
    }
}
// @lc code=end

