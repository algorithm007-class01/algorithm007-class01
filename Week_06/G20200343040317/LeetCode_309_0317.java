class Solution {
    // dp[i] 第i天的最大收益
    // 这里有一个问题，存在3中状态
    // 0 持股
    // 1 不持股
    // 2 冻结


    public int maxProfit(int[] prices) {
        final int length = prices.length;
        if (length < 2) {
            return 0;
        }
        final int[][] dp = new int[length][3];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][2] - prices[i], dp[i - 1][0]);
            dp[i][1] = Math.max(Math.max(dp[i - 1][0] + prices[i], dp[i][1]), dp[i][2]);
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }
        return Math.max(Math.max(dp[length - 1][0], dp[length - 1][1]), dp[length - 1][2]);
    }
}