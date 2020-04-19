class Solution {
    // dp[i] 第i天获得的最大收益。貌似有问题，这个与前一天的买卖有关系，所以dp一维的不够用，需要再添加一维的状态
    // 0 第i天持有股票
    // 1 第i天不持有股票
    // 注意这一的dp求的是最大属性值
    // 那么dp应该如何递推呢？
    // dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i])
    // dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        final int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][1]);
    }
}