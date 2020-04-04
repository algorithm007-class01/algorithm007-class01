/*
 * @lc app=leetcode.cn id=46 lang=csharp
 *
 * [46] 全排列
 */

// @lc code=start
using System;
using System.Collections.Generic;

public class Solution {

    public IList<IList<int>> Permute (int[] nums) {
        List<IList<int>> res = new List<IList<int>> ();
        int[] visited = new int[nums.Length];
        backtrack (res, nums, new List<int> (), visited);
        return res;
    }

    private void backtrack (List<IList<int>> res, int[] nums, List<int> list, int[] visited) {
        if (list.Count == nums.Length) {
            res.Add (new List<int> (list));
            return;
        }

        for (int i = 0; i < nums.Length; i++) {
            if (visited[i] == 1) {
                continue;
            }
            visited[i] = 1;
            list.Add (nums[i]);
            backtrack (res, nums, list, visited);
            visited[i] = 0;
            list.RemoveAt (list.Count - 1);
        }
    }

}
// @lc code=end