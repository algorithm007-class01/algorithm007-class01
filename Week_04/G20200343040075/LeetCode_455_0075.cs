/*
 * @lc app=leetcode.cn id=455 lang=csharp
 *
 * [455] 分发饼干
 */

// @lc code=start
using System;

public class Solution {
    /// <summary>
    /// 贪心的实现
    /// </summary>
    /// <param name="g"></param>
    /// <param name="s"></param>
    /// <returns></returns>
    public int FindContentChildren (int[] g, int[] s) {
        Array.Sort (g);
        Array.Sort (s);
        int res = 0;
        int i = 0;
        int j = 0;
        while (i < g.Length) {
            while (j < s.Length) {
                if (g[i] <= s[j++]) {
                    res++;
                    break;
                }
            }
            i++;
        }
        return res;
    }
}
// @lc code=end