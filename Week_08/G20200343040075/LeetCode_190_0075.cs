/*
 * @lc app=leetcode.cn id=190 lang=csharp
 *
 * [190] 颠倒二进制位
 */

// @lc code=start
public class Solution {
    /// <summary>
    /// 直接用左右位移实现
    /// </summary>
    /// <param name="n"></param>
    /// <returns></returns>
    public uint reverseBits (uint n) {
        uint ret = 0;
        for (int i = 0; i < sizeof (uint) * 8; i++) {
            ret = (ret << 1) + (n & 1);
            n = (n >> 1);
        }
        return ret;
    }
}
// @lc code=end