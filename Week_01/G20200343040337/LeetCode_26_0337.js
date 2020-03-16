/*
 * @lc app=leetcode.cn id=26 lang=javascript
 *
 * [26] 删除排序数组中的重复项
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function(nums) {
  let j = 0; // 变量 j 用于存放所有非重复项的最后一项的下标
  for ( let i = 1, len = nums.length; i < len; i++ ) {
    // 从数组第二项开始遍历，若遇到不同的项，那么就说明多了一项未重复项，将其放到++j的位置
    nums[i] != nums[j] && ( nums[++j] = nums[i] );
  }
  return j + 1; // 由于j是最后一项非重复项的下标，所以j+1即为要求的长度
};
// @lc code=end

