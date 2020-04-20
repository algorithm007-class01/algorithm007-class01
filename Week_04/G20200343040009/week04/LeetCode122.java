public class LeetCode122 {
    /**
     * 找寻谷峰与谷底最大差即可
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            // 当前购买点比前一购买点大即跟加到maxProfit
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }
}
