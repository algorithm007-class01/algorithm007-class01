/*
 * @lc app=leetcode.cn id=189 lang=csharp
 *
 * [189] 旋转数组
 */

// @lc code=start
using System;

public class Solution {
    public void Rotate(int[] nums, int k) {
        int count = nums.Length;
        if (count <= 1) return;
        // // 暴力法(超时了)
        // 三次反转法相对好理解
        // 类似与负负得正
        // 只有k大于count时，才是对应位数的整体移动，否则只是余数位的移动
        k %= count;
        reverse(nums, 0, count - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, count - 1);
    }

    private void reverse(int[] nums, int s, int e)
    {
        int tmp;
        while (s < e)
        {
            tmp = nums[s];
            nums[s++] = nums[e];
            nums[e--] = tmp;
        }
    }
}
// @lc code=end

