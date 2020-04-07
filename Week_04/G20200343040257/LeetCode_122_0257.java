package cxl.study.leetcode;

/**
 * 122. 买卖股票的最佳时机 II
 * https://leetcode-cn.com/problems/12/description/
 */
public class LeetCode_122_0257 {

    public int maxProfit(int[] prices) {
        int maxResult = 0;
        for (int i = 0; i < prices.length; i++) {
            if (i < prices.length - 1 && prices[i] < prices[i + 1]) {
                maxResult += prices[i + 1] - prices[i];
            }
        }
        return maxResult;
    }

}
