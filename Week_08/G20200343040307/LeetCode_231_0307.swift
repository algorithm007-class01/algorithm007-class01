/*
 * @lc app=leetcode.cn id=231 lang=swift
 *
 * [231] 2的幂
 */

// @lc code=start
class Solution {
    func isPowerOfTwo(_ n: Int) -> Bool {
        if n&(n-1) != 0 {
            return false
        }
        return n != 0
    }
}

class Solution {
    func isPowerOfTwo(_ n: Int) -> Bool {
        if n&(-n) != n {
            return false
        }
        return n != 0
    }
}
// @lc code=end

