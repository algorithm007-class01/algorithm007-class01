//给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。 
//
// 示例 1: 
//
// 
//输入: "abc"
//输出: 3
//解释: 三个回文子串: "a", "b", "c".
// 
//
// 示例 2: 
//
// 
//输入: "aaa"
//输出: 6
//说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
// 
//
// 注意: 
//
// 
// 输入的字符串长度不会超过1000。 
// 
// Related Topics 字符串 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countSubstrings(String s) {
        char[] chars = s.toCharArray();
        int size = chars.length;
        int[] dp = new int[size + 1];
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < size + 1; ++i) {
            int num = queue.size();
            count = 1;
            for (int j = 0; j < num; ++j) {
                int l = queue.poll();
                if (l > 0 && chars[l - 1] == chars[i - 1]) {
                    count++;
                    queue.offer(l - 1);
                }
            }
            queue.offer(i - 1);
            if (i > 1 && chars[i - 1] == chars[i - 2]) {
                queue.offer(i - 2);
                count++;
            }
            dp[i] = dp[i - 1] + count;
        }
        return dp[size];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
