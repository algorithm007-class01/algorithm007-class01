class Solution {
    public int maxProfit(int[] prices) {
        int profile = 0;
        // 入参校验
        if (prices.length < 2) {
            return profile;
        }
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                profile += prices[i] - prices[i - 1];
            }
        }
        return profile;
    }
}