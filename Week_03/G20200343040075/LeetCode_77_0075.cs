/*
 * @lc app=leetcode.cn id=77 lang=csharp
 *
 * [77] 组合
 */

// @lc code=start
using System;
using System.Collections.Generic;

public class Solution {
    private List<IList<int>> res = new List<IList<int>> ();

    public IList<IList<int>> Combine (int n, int k) {
        recursive (1, n, k, new List<int> ());
        return res;
    }

    private void recursive (int s, int n, int k, List<int> list) {
        if (list.Count == k) {
            res.Add (list);
            return;
        }

        for (int i = s; i < n + 1; i++) {
            list.Add (i);
            recursive (i + 1, n, k, new List<int> (list));
            list.RemoveAt (list.Count - 1);
        }
    }
}
// @lc code=end