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


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int result = 2;
        Queue<String> queue = new LinkedList<>();
        boolean[] visited = new boolean[wordList.size()];
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                String s = queue.poll();
                for (int j = 0; j < wordList.size(); ++j)
                    if (!visited[j] && isAvaiable(s, wordList.get(j))) {
                        if (wordList.get(j).equals(endWord))
                            return result;
                        queue.offer(wordList.get(j));
                        visited[j] = true;
                    }
            }
            result++;
        }
        return 0;
    }

    private boolean isAvaiable(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); ++i)
            if (s1.charAt(i) != s2.charAt(i))
                count++;
        return count == 1;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
