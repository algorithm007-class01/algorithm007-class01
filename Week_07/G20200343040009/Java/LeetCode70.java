/**
 *  1. 重复子问题：dp(i) = dp(i - 1) + dp(i - 2)
 *  2. 状态：dp[i]
 *  3. 推导式：dp[i] = dp[i - 1] + dp[i - 2];
 */
public class LeetCode70 {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
