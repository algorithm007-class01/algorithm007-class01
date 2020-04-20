/*
 * @lc app=leetcode.cn id=1 lang=javascript
 *
 * [1] 两数之和
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
  for (let hmap = new Map, i = 0, len = nums.length; i < len; i++) {
    let left = target - nums[i];
    if (hmap.has(left)) return [ hmap.get(left), i ]
    hmap.set(nums[i], i);
  }
};
// @lc code=end

