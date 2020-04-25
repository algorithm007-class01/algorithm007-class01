/*
 * @lc app=leetcode.cn id=153 lang=java
 *
 * [153] 寻找旋转排序数组中的最小值
 */

// @lc code=start
class Solution {
    public int findPosition(int[] nums) {
        if (nums.length == 1) return -1;
        int left = 0, right = nums.length - 1;
        if (nums[left] < nums[right]) return -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid + 1] < nums[mid]) return mid + 1;
            if (nums[mid - 1] > nums[mid]) return mid;
            if (nums[left] < nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
// @lc code=end

