/*
 * @lc app=leetcode.cn id=189 lang=javascript
 *
 * [189] 旋转数组
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var rotate = function(nums, k) {

  // 方法一, js暴力破解
  // let i = k
  // while (i > 0) {
  //   nums.unshift(nums.pop())
  //   i--
  // }

  // 方法二, 翻转三次
  k = k % nums.length
  const reverse = (arr, left, right) => {
    while (left < right) {
      const temp = arr[left]
      arr[left] = arr[right]
      arr[right] = temp
      left++
      right--
    }
  }
  reverse(nums, 0, nums.length - 1)
  reverse(nums, 0, k - 1)
  reverse(nums, k, nums.length - 1)
};
// @lc code=end

