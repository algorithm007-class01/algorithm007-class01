package l01.n127;//给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
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


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution127 {
    /**
     * BFS
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                String start = queue.poll();
                for (String s : wordList) {
                    if (visited.contains(s)) {
                        continue;
                    }
                    if (!canConvert(start, s)) {
                        continue;
                    }
                    if (s.equals(endWord)) {
                        return count + 1;
                    }
                    visited.add(s);
                    queue.offer(s);
                }
            }

        }
        return 0;

    }


    /**
     * 双向BFS
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        wordList.add(beginWord);
        Set<String> visited1 = new HashSet<>();
        Queue<String> queue1 = new LinkedList<>();
        queue1.offer(beginWord);
        visited1.add(beginWord);
        int count1 = 0;

        Set<String> visited2 = new HashSet<>();
        Queue<String> queue2 = new LinkedList<>();
        queue2.offer(endWord);
        visited2.add(endWord);
        int count2 = 0;

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            count1++;
            int size1 = queue1.size();
            while (size1-- > 0) {
                String s = queue1.poll();
                for (String word : wordList) {
                    if (visited1.contains(word)) {
                        continue;
                    }
                    if (!canConvert(s, word)) {
                        continue;
                    }
                    if (visited2.contains(word)) {
                        return count1 + count2 + 1;
                    }
                    queue1.offer(word);
                    visited1.add(word);
                }
            }
            count2++;
            int size2 = queue2.size();
            while (size2-- > 0) {
                String s = queue2.poll();
                for (String word : wordList) {
                    if (visited2.contains(word)) {
                        continue;
                    }
                    if (!canConvert(s, word)) {
                        continue;
                    }
                    if (visited1.contains(word)) {
                        return count1 + count2 + 1;
                    }
                    queue2.offer(word);
                    visited2.add(word);
                }
            }
        }

        return 0;

    }

    /**
     * 优化双端BFS，每一次从更少的队列开始遍历
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength3(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        wordList.add(beginWord);
        Set<String> visited1 = new HashSet<>();
        Queue<String> queue1 = new LinkedList<>();
        queue1.offer(beginWord);
        visited1.add(beginWord);
        int count = 0;

        Set<String> visited2 = new HashSet<>();
        Queue<String> queue2 = new LinkedList<>();
        queue2.offer(endWord);
        visited2.add(endWord);

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            // 从数量较少的队列开始遍历
            if (queue1.size() > queue2.size()) {
                Queue<String> temp = queue1;
                queue1 = queue2;
                queue2 = temp;

                Set<String> tempv = visited1;
                visited1 = visited2;
                visited2 = tempv;
            }
            count++;
            int size = queue1.size();
            while (size-- > 0) {
                String s = queue1.poll();
                for (String word : wordList) {
                    if (visited1.contains(word)) {
                        continue;
                    }
                    if (!canConvert(s, word)) {
                        continue;
                    }
                    if (visited2.contains(word)) {
                        return count + 1;
                    }
                    queue1.offer(word);
                    visited1.add(word);
                }
            }
        }

        return 0;

    }

    private boolean canConvert(String s, String endWord) {
        if (s.length() != endWord.length()) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != endWord.charAt(i)) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
