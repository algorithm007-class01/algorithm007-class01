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
  if (nums.length < 2) return []; // 不足两数，无结果

  let obj = {};
  for (let i = 0; i < nums.length; i++) {
    obj[nums[i]] = i;
  }

  for (let i = 0; i < nums.length; i++) {
    let left = target - nums[i]
    if (obj[left] >= 0 && i != obj[left]) {
      return i < obj[left] ? [i , obj[left]] : [obj[left], i];
    }
  }
  return [];
};
// @lc code=end

