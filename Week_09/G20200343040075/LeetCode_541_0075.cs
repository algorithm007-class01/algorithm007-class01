/*
 * @lc app=leetcode.cn id=541 lang=csharp
 *
 * [541] 反转字符串 II
 */

// @lc code=start
using System;

public class Solution {
    /// <summary>
    /// 暴力解
    /// 需注意剩余小于2k部分的反转前的下标值
    /// </summary>
    /// <param name="s"></param>
    /// <param name="k"></param>
    /// <returns></returns>
    public string ReverseStr (string s, int k) {
        char[] res = s.ToCharArray ();
        int sLen = s.Length;
        for (int i = 0; i < sLen; i += 2 * k) {
            int len = Math.Min (sLen, i + k);
            reverse (s, res, i, len - 1);
        }
        int leave = sLen % (2 * k), index = sLen - leave, last = Math.Min (leave, k);
        reverse (s, res, index, index + last - 1);
        return new string (res);
    }

    private void reverse (string s, char[] res, int m, int n) {
        while (m < n) {
            res[m] = s[n];
            res[n--] = s[m++];
        }
    }
}
// @lc code=end