/*
 * @lc app=leetcode.cn id=122 lang=swift
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start
// 简单粗暴的贪心算法思路：从后往前遍历，之后后者大于前者就累加
// 贪心算法知识相关：每次就比较前后两者，只要是递增就是有收益

// class Solution {
//     func maxProfit(_ prices: [Int]) -> Int {
//         if prices.count < 2 {
//             return 0
//         }
//         var ans = 0
//         for i in (1..<prices.count).reversed() {
//             if prices[i] > prices[i-1] {
//                 ans += (prices[i] - prices[i-1])
//             }
//         }
//         return ans
//     }
// }

// 为什么使用动态规划 （https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/solution/tan-xin-suan-fa-by-liweiwei1419-2/）
// 1.可以用贪心算法解决的问题，一般情况下都可以用动态规划。
// 因此，不妨从 “状态”、“状态转移方程” 的角度考虑一下，
// 使用动态规划的思路解决这道问题。

// 动态规划：每次记录第 i 天不操作和买入的最大收益
// 一组数组记录不操作的最大收益
// 另一个数组记录每次都买入的最大收益
// dp[i][0] = max(dp[i-1][0], dp[i-1][1]+prices[i])
// dp[i][1] = max(dp[i-1][0]-prices[i], dp[i-1][1])

// 因为新的结果都是根据前两者就可产生
// 所以两个数组就可以转换成两个变量

class Solution {
    func maxProfit(_ prices: [Int]) -> Int {
        if prices.count < 2 {
            return 0
        }
        var x0 = 0
        var x1 = -prices[0]
        var tmp = x0
        for i in 1..<prices.count {
            x0 = max(tmp, x1+prices[i])
            x1 = max(tmp-prices[i], x1)
            tmp = x0
        }
        return x0
    }
}

// @lc code=end

