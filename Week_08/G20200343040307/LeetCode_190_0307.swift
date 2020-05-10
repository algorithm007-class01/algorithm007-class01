/*
 * @lc app=leetcode.cn id=190 lang=swift
 *
 * [190] 颠倒二进制位
 */

// @lc code=start
class Solution {
    func reverseBits(_ n: Int) -> Int {
        var ans = 0
        var index = 31
        var cur = n
        while index >= 0 {
            ans += ((cur&1) << index)
            cur = cur >> 1
            index -= 1 
        }
        return ans
    }
}

class Solution {
    func reverseBits(_ n: Int) -> Int {
        var cur = n
        cur = (cur >> 16) | (cur << 16)
        cur = ((cur & 0xff00ff00) >> 8) | ((cur & 0x00ff00ff) << 8)
        cur = ((cur & 0xf0f0f0f0) >> 4) | ((cur & 0x0f0f0f0f) << 4)
        cur = ((cur & 0xcccccccc) >> 2) | ((cur & 0x33333333) << 2)
        cur = ((cur & 0xaaaaaaaa) >> 1) | ((cur & 0x55555555) << 1)
        return cur
    }
}
// 注释
//1111 1111 0000 0000 1111 1111 0000 0000
//1111 0000 1111 0000 1111 0000 1111 0000  
//1100 1100 1100 1100 1100 1100 1100 1100 
//1010 1010 1010 1010 1010 1010 1010 1010

// @lc code=end

