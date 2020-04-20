/*
 * @lc app=leetcode.cn id=283 lang=javascript
 *
 * [283] 移动零
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var moveZeroes = function(nums) {
  for ( let i = 0, j = 0, len = nums.length; j < len; j++ ) {
    if (nums[j] != 0) {
      nums[i] = nums[j];
      if (j > i) {
        nums[j] = 0;
      }
      i++;
    }
  }
};
// @lc code=end

