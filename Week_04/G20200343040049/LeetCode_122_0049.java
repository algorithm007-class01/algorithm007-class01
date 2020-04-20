class Solution {
    public int maxProfit(int[] prices) {
        int revenue = 0;
        for(int i = 0; i < prices.length - 1; ++i) {
            if(prices[i + 1] > prices[i])
                revenue += prices[i + 1] - prices[i];
        }
        return revenue;
    }
}