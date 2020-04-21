package myself;

public class LeetCode_122_0201 {

    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int sell = 1;
        int profit = 0;

        while (sell < prices.length) {
            if (prices[sell] > prices[sell - 1]) {
                profit += (prices[sell] - prices[sell - 1]);
            }
            sell++;
        }
        return profit;
    }

}
