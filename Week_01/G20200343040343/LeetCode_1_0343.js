/*
 * @lc app=leetcode.cn id=26 lang=javascript
 *
 * [26] 删除排序数组中的重复项
 */
/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function(nums) {
  // 1. 遍历把元素塞入set
  // 2. 双指针
  let i = 0, j = 1
  while (j < nums.length) {
    if (nums[i] !== nums[j]) {
      i++
      nums[i] = nums[j]
    }
    j++
  }
  return i + 1
};

