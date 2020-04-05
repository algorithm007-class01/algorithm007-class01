/*
 * @lc app=leetcode.cn id=455 lang=swift
 *
 * [455] 分发饼干
 */

// @lc code=start
// 第一遍刷题，将两个数组排序，直接将两个数组个数进行操作
// 没有考虑到饼干的最小尺寸没法满足孩子的最小胃口
// 贪心算法相关：优先满足最小尺寸饼干满足最小胃口的孩子

class Solution {
    func findContentChildren(_ g: [Int], _ s: [Int]) -> Int {
         var size = s.sorted(by: <)
         var child = g.sorted(by: <)

         var ss = 0
         var gg = 0
         while ss < size.count && gg < child.count {
             if size[ss] >= child[gg] {
                 gg += 1
             }
             ss += 1
         }
         return gg
    }
}
// @lc code=end

