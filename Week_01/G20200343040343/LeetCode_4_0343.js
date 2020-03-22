/*
 * @lc app=leetcode.cn id=88 lang=javascript
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
/**
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 */
var merge = function(nums1, m, nums2, n) {
  // 1. 同时遍历2个数组，放入一个新数组中
  // const len = m > n ? n : m
  // let temp = []
  // let i = 0
  // let j = 0
  // while (i < m && j < n) {
  //   if (nums1[i] < nums2[j]) {
  //     temp.push(nums1[i])
  //     i++
  //   }
  //   if (nums1[i] > nums2[j]) {
  //     temp.push(nums2[j])
  //     j++
  //   }
  //   if (nums1[i] === nums2[j]) {
  //     temp.push(nums1[i])
  //     temp.push(nums2[j])
  //     i++
  //     j++
  //   }
  // }
  // if (i === m) {
  //   temp = temp.concat(nums2.slice(j))
  // }
  // if (j === n) {
  //   temp = temp.concat(nums1.slice(i))
  // }
  // temp = temp.slice(0, m + n)
  // for (let i = 0; i < temp.length; i++) {
  //   nums1[i] = temp[i]
  // }
  // return

  // 2. 全部放入一个数组中进行排序
  // for (let i = 0; i < n; i++) {
  //   nums1[m + i] = nums2[i]
  // }
  // nums1.sort((a, b) => a - b)
  // return

  // 3. 从后向前遍历
  let i = m - 1, j = n - 1, k = m + n - 1
  while (i >= 0 && j >= 0) {
    nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--]
  }
  while (j >= 0) {
    nums1[j] = nums2[j--]
  }
  return
}
// @lc code=end
