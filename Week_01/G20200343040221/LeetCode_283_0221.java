/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 *
 * https://leetcode-cn.com/problems/move-zeroes/description/
 *
 * algorithms
 * Easy (59.88%)
 * Likes:    516
 * Dislikes: 0
 * Total Accepted:    118.3K
 * Total Submissions: 197.7K
 * Testcase Example:  '[0,1,0,3,12]'
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 
 * 示例:
 * 
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 
 * 说明:
 * 
 * 
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * 
 * 
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        int nextNonZeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[nextNonZeroIndex++] = nums[i];
            }
        }
        for (int i = nextNonZeroIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
// @lc code=end

