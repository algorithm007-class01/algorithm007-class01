/*
 * @lc app=leetcode.cn id=122 lang=csharp
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start
public class Solution {
    /// <summary>
    /// 贪心算法
    /// </summary>
    /// <param name="prices"></param>
    /// <returns></returns>
    public int MaxProfit (int[] prices) {
        int profit = 0;
        int count = prices.Length;
        if (count > 1) {
            // 当前价格
            int curPrice = prices[0];
            for (int i = 1; i < count; i++) {
                int thePrice = prices[i];
                // 如价格上涨，则卖出，收下利润
                if (thePrice > curPrice) {
                    profit += thePrice - curPrice;
                }
                if ((i + 1) < count) {
                    // 如明天价格上涨，则今天买入
                    if (thePrice < prices[i + 1]) {
                        curPrice = thePrice;
                    } else {
                        // 否则买入明天的
                        curPrice = prices[i + 1];
                    }
                }
            }
        }
        return profit;
    }
}
// @lc code=end