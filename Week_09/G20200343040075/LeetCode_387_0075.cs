/*
 * @lc app=leetcode.cn id=387 lang=csharp
 *
 * [387] 字符串中的第一个唯一字符
 */

// @lc code=start
using System.Collections.Generic;

public class Solution {
    /// <summary>
    /// 暴力 + hash
    /// </summary>
    /// <param name="s"></param>
    /// <returns></returns>
    public int FirstUniqChar2 (string s) {
        Dictionary<char, int> dic = new Dictionary<char, int> ();
        for (int i = 0; i < s.Length; i++) {
            dic[s[i]] = dic.ContainsKey (s[i]) ? dic[s[i]] + 1 : 1;
        }
        for (int i = 0; i < s.Length; i++) {
            if (dic[s[i]] == 1) return i;
        }
        return -1;
    }

    /// <summary>
    /// 因限定了只有小写字母，所以用数组计数效率更高
    /// </summary>
    /// <param name="s"></param>
    /// <returns></returns>
    public int FirstUniqChar (string s) {
        int[] arr = new int[26];
        for (int i = 0; i < s.Length; i++) {
            arr[s[i] - 'a']++;
        }
        for (int i = 0; i < s.Length; i++) {
            if (arr[s[i] - 'a'] == 1) return i;
        }
        return -1;
    }
}
// @lc code=end