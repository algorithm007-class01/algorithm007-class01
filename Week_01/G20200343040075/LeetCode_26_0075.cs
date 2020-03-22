/*
 * @lc app=leetcode.cn id=26 lang=csharp
 *
 * [26] 删除排序数组中的重复项
 */

// @lc code=start
public class Solution {
    public int RemoveDuplicates(int[] nums) {
        int count = nums.Length;
        if (count <= 1)
            return count;

        // int tmp = nums[count - 1];
        // 把不重复的项排中前面,缩减数组长度
        // 采用快慢双指针法 O(n)/O(1)
        int i = 0;
        int tmp = nums[i];
        for (int j = 1; j < count; j++)
        {
            if (tmp != nums[j])
            {
                // i++;
                tmp = nums[j];
                nums[++i] = tmp;
            }
        }
        // 数量需加1
        return i + 1;
    }
}
// @lc code=end

