
public class LeetCode_122_0145 {

    /**
     *  股票最大利润收益，只要后一天价格大于前一天就购买
     *  循环到倒数第二天
     * */
    public static int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                profit += (prices[i + 1] - prices[i]);
            }

        }
        return profit;
    }

}
