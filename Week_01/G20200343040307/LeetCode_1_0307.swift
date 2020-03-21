/*
 * @lc app=leetcode.cn id=1 lang=swift
 *
 * [1] 两数之和
 */

// @lc code=start
// 暴力解法： 双层循环
    // for i in 0..<nums.count-1 {
    //     for j in (i + 1)..<nums.count {

    //     }
    // }
// 解法二： 字典
class Solution {
    func twoSum(_ nums: [Int], _ target: Int) -> [Int] {
        var dict: [Int: Int] = [:]
        for (i, n) in nums.enumerated() {
            if let index = dict[target - n] {
                return [i, index]
            }
            dict[n] = i
        } 
        return []
    }
}
// 解法三： 哈希表 TODO
// @lc code=end

