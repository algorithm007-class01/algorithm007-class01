//给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。 
//
// 示例 1: 
//
// 输入: "(()"
//输出: 2
//解释: 最长有效括号子串为 "()"
// 
//
// 示例 2: 
//
// 输入: ")()())"
//输出: 4
//解释: 最长有效括号子串为 "()()"
// 
// Related Topics 字符串 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestValidParentheses(String s) {
        int size = s.length();
        if (size < 2) return 0;
        int[] dp = new int[size + 1];
        int max = 0;
        for (int i = 1; i <= size; ++i) {
            if (s.charAt(i - 1) == '(')
                dp[i] = 0;
            else {
                int l = (i - 1) - dp[i - 1] - 1;
                if (l < 0 || s.charAt(l) == ')')
                    dp[i] = 0;
                else
                    dp[i] = dp[l] + dp[i - 1] + 2;
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
