/*
 * @lc app=leetcode.cn id=56 lang=swift
 *
 * [56] 合并区间
 */

// @lc code=start
class Solution {
    func merge(_ intervals: [[Int]]) -> [[Int]] {
        let res = intervals.sorted { (fir, sec) -> Bool in
           fir[0] < sec[0]
        }
        var ans = [[Int]]()
        var index = -1
        for rang in res {
            if index == -1 || ans[index][1] < rang[0] {
                index += 1
                ans.append(rang)
            }else{
                ans[index][1] = max(ans[index][1], rang[1])
            }
        }
        return ans
    }
}
// @lc code=end

