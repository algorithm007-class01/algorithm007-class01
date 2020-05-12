/*
 * @lc app=leetcode.cn id=191 lang=swift
 *
 * [191] 位1的个数
 */

// @lc code=start
class Solution {
    func hammingWeight(_ n: Int) -> Int {
        var cur = n
        var count = 0
        while cur > 0 {
            cur = cur&(cur-1)
            count += 1
        }
        return count
    }
}

// 二
lass Solution {
    func hammingWeight(_ n: Int) -> Int {
        var mask = 1
        var count = 0
        while mask <= n {
            if mask & n != 0{
                count += 1
            }
            mask = mask << 1
        }
        return count
    }
}
// @lc code=end

