class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        if (n <= 1) return 0;
        // dp[i] 以s.charAt(i)字符结尾的有效括号长度
        int[] dp = new int[n];
        int max = 0;

        for (int i = 1; i < n; ++i) {
            if (s.charAt(i) == '(') continue;
            if (s.charAt(i - 1) == '(') dp[i] = i >= 2 ? dp[i - 2] + 2 : 2;
            else if (i >= dp[i - 1] + 1 && s.charAt(i - dp[i - 1] - 1) == '(')
                dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}