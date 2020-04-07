/**
 * 122  买卖股票的最佳时机 II
 * 峰谷法
 * 
 * 关键是我们需要考虑到紧跟谷的每一个峰值以最大化利润。
 * 如果我们试图跳过其中一个峰值来获取更多利润，那么我们最终将失去其中一笔交易中获得的利润，从而导致总利润的降低。
 * 
 * 个人理解就是每次一个峰谷都要计算，把每次的收益都加总在内
 * 
 * 复杂度分析

    时间复杂度：O(n)。遍历一次。

    空间复杂度：O(1)。需要常量的空间。
 */
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int maxProfit = 0;
        int valley = prices[0];
        int peak = prices[0];
        int i = 0;
        while (i < prices.length - 1) {
            // 找低谷
            while (i < prices.length - 1 && prices[i] >= prices[i+1]) {
                i++;
            }
            valley = prices[i];
            // 找峰值
            while (i < prices.length - 1 && prices[i] <= prices[i+1]) {
                i++;
            }
            peak = prices[i];

            maxProfit += peak - valley;
        }
        return maxProfit;
    }
}