using System;
/*
 * @lc app=leetcode.cn id=49 lang=csharp
 *
 * [49] 字母异位词分组
 */

// @lc code=start
using System.Collections.Generic;

public class Solution {
    /// <code>
    /// 排序字符串形成固定的key，以此判断是否相同
    /// </code>
    public IList<IList<string>> GroupAnagrams(string[] strs) {
        if (strs == null || strs.Length == 0)
        {
            return new List<IList<string>>();
        }
        Dictionary<string, IList<string>> dic = new Dictionary<string, IList<string>>();
        foreach (string str in strs)
        {
            char[] arr = str.ToCharArray();
            Array.Sort(arr);
            string key = string.Join("", arr);
            if (!dic.ContainsKey(key))
                dic[key] = new List<string>();
            dic[key].Add(str);
        }
        return new List<IList<string>>(dic.Values);
    }
}
// @lc code=end

