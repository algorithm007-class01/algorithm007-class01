/*
 * @lc app=leetcode.cn id=1 lang=csharp
 *
 * [1] 两数之和
 */

// @lc code=start
using System.Collections.Generic;

public class Solution {
    public int[] TwoSum(int[] nums, int target) {
        // 把出现过的元素存入字典<元素,下标>，用于查询O(1)
        Dictionary<int, int> dic = new Dictionary<int, int>();
        for (int i = 0; i < nums.Length; i++)
        {
            dic[nums[i]] = i;
        }
        for (int i = 0; i < nums.Length; i++)
        {
            int v = target - nums[i];
            if (dic.ContainsKey(v))
            {
                int j = dic[v];
                // 避免重复利用
                if (i != j)
                    return new int[]{i, j};
            }
        }
        return new int[0];
    }
}
// @lc code=end

