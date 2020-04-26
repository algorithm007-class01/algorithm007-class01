package com.week06;

/**
 * 1. 重复子问题：
 *              每查询两次就找到括号：dp(i) = dp(i - 2) + 2
 *              如有))：dp(i) = dp(i - 1) + dp(i - dp(i - 1) - 2) + 2
 * 2. 中间状态：dp[i]
 * 3. 推导公式：
 *              1. dp[i] = dp[i - 2] + 2;
 *              2. dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2;
 *
 * 最长有效括号
 */
public class LeetCode32 {
    public int longestValidParentheses(String s) {
        int maxNum = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxNum = Math.max(maxNum, dp[i]);
            }
        }
        return maxNum;
    }
}
