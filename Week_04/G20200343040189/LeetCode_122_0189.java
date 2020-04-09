//给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
// 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
//
// Related Topics 贪心算法 数组

//leetcode submit region begin(Prohibit modification and deletion)

/**
 *
 * 贪心算法时间复杂度一般是线性的，空间复杂度是常数级别的。
 *
 * 这道题 “贪心” 的地方在于，对于 “今天的股价 - 昨天的股价”，得到的结果有 3 种可能：
 * （1）正数（2）0（3）负数。
 *
 * 贪心算法的决策是：只加正数。
 */
class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int len = prices.length;
        if (len == 0 || prices == null) {
            return 0;
        }
        // 对数组进行遍历，如果后一天股价大于前一天股价，则售出，将盈利累加
        for (int i = 0; i < len; i++) {
            if (i > 0) {
                int temp = prices[i] - prices[i-1];
                if (temp > 0) {
                    profit += temp;
                }
            }
        }
        return profit;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
