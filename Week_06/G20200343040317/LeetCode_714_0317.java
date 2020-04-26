class Solution {
    // dp[i] 第i天的最大收益，
    // 第i天的收益存在买入 卖出两种状态，所以需要给dp[i] 在增加一个维度 0 买入 1 卖出
    // dp[i][0]= Math.max(dp[i-1][0],dp[i-1][1]-prices[i])
    // dp[i][1]= Math.max(dp[i-1][0]+prices[i]-fee,dp[i-1][1])
    public int maxProfit(int[] prices, int fee) {
        if (prices.length == 0) {
            return 0;
        }
        final int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i] - fee, dp[i - 1][1]);
        }
        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][1]);
    }
}