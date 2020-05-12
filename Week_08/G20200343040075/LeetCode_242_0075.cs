/*
 * @lc app=leetcode.cn id=242 lang=csharp
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
using System;

public class Solution {
    /// <summary>
    /// 哈希
    /// </summary>
    /// <param name="s"></param>
    /// <param name="t"></param>
    /// <returns></returns>
    public bool IsAnagram2 (string s, string t) {
        if (s.Length != t.Length)
            return false;

        int[] arr = new int[26];
        foreach (var ch in s.ToCharArray ()) {
            arr[ch - 'a']++;
        }
        foreach (var ch in t.ToCharArray ()) {
            if (--arr[ch - 'a'] < 0)
                return false;
        }
        return true;
    }

    /// <summary>
    /// 排序
    /// </summary>
    /// <param name="s"></param>
    /// <param name="t"></param>
    /// <returns></returns>
    public bool IsAnagram (string s, string t) {
        if (s.Length != t.Length) return false;
        char[] arr1 = s.ToCharArray ();
        char[] arr2 = t.ToCharArray ();
        Array.Sort (arr1);
        Array.Sort (arr2);
        return new string(arr1) == new string(arr2);
    }

}
// @lc code=end