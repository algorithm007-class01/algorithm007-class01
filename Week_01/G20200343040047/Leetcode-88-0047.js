/**
 * 88. 合并两个有序数组 https://leetcode-cn.com/problems/merge-sorted-array/
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 */
var merge = function(nums1, m, nums2, n) {
  while (m >= 0 && n > 0) {
    let maxNum = m + n;
    if (nums1[m - 1] > nums2[n - 1]) {
      nums1[maxNum - 1] = nums1[m - 1];
      m--;
    } else {
      nums1[maxNum - 1] = nums2[n - 1];
      n--;
    }
  }
};
// 代码优化
// var merge = function(nums1, m, nums2, n) {
//     let maxNum = m + n;
//     while(m >= 0 && n > 0){
//         nums1[--maxNum] = nums1[m - 1] > nums2[n - 1] ? nums1[--m] : nums2[--n];
//     }
// };
