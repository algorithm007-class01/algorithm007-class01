/*
 * @lc app=leetcode.cn id=283 lang=csharp
 *
 * [283] 移动零
 */

// @lc code=start
public class Solution {
    public void MoveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.Length; i++)
        {
            // 不为0的值移到最近一个值为0的下标处，后面的就都为0了
            if (nums[i] != 0)
            {
                nums[j] = nums[i];
                if (i != j)
                {
                    nums[i] = 0;
                }
                j++;
            }
        }
    }
}
// @lc code=end

