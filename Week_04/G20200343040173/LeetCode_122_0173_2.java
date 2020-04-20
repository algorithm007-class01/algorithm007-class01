/**
 * 122  买卖股票的最佳时机 II
 * 遍历法

 * 只要是持续上升的趋势，都加起来作为收益
 * 
 * 复杂度分析

    时间复杂度：O(n)。遍历一次。

    空间复杂度：O(1)。需要常量的空间。
 */
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }
}