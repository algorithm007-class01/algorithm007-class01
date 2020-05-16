/*
 * @lc app=leetcode.cn id=231 lang=csharp
 *
 * [231] 2的幂
 */

// @lc code=start
public class Solution {
    /// <summary>
    /// 暴力解
    /// </summary>
    /// <param name="n"></param>
    /// <returns></returns>
    public bool IsPowerOfTwo2 (int n) {
        if (n == 0) return false;
        while (n % 2 == 0) {
            n = n >> 1;
        }
        return n == 1;
    }

    /// <summary>
    /// 根据幂次的二进制特殊性：只有1位1
    /// 注：-1 的边界
    /// </summary>
    /// <param name="n"></param>
    /// <returns></returns>
    public bool IsPowerOfTwo3 (int n) {
        if (n == 0) return false;
        //-2147483648 - 1 int 溢出
        if (n == int.MinValue) {
            long x = (long)n;
            return (x & (x - 1)) == 0;
        } else {
            return (n & (n - 1)) == 0;
        }
    }

    /// <summary>
    /// 位运算: x & (-x) 保留最右侧的 1
    /// </summary>
    /// <param name="n"></param>
    /// <returns></returns>
    public bool IsPowerOfTwo (int n) {
        if (n == 0) return false;
        if (n == int.MinValue) {
            long x = (long)n;
            return (x & (-x)) == x;
        } else {
            return (n & (-n)) == n;
        }
    }
}
// @lc code=end