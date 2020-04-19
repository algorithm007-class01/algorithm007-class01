public class LeetCode_122_0147 {
    public int maxProfit(int[] prices) {
        int sumary = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                sumary += prices[i] - prices[i - 1];
            }
        }
        return sumary;
    }
}
