/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 *
 * https://leetcode-cn.com/problems/jump-game/description/
 *
 * algorithms
 * Medium (38.31%)
 * Likes:    535
 * Dislikes: 0
 * Total Accepted:    76.9K
 * Total Submissions: 199.3K
 * Testcase Example:  '[2,3,1,1,4]'
 *
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 
 * 判断你是否能够到达最后一个位置。
 * 
 * 示例 1:
 * 
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 
 * 
 * 示例 2:
 * 
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        if (null == nums) {
            return false;
        }
        int endReachable = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= endReachable) {
                endReachable = i;
            }
        }
        return endReachable == 0;
    }
    // 两层循环，N平方
    public boolean canJump1(int[] nums) {
        if (null == nums) {
            return false;
        }

        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (i == length - 1) {
                return true;
            }
            int num = nums[i];
            if (num == 0 && !canJump(nums, i)) {
                return false;
            }
        }
        return true;
    }
    private boolean canJump(int[] nums, int currentZeroPosition) {
        for (int i = currentZeroPosition - 1; i >= 0; i--) {
            if (currentZeroPosition - i < nums[i]) {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end

