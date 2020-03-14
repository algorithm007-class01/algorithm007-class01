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
  var move = function (start) {   // 定义函数，用于将nums1中从start开始的所有数后移一位
    let last = m;
    for (; last > start;) {
      nums1[last] = nums1[--last];
    }
  }

  let i = 0, j = 0; // 两个下标，分别用于遍历nums1以及nums2
  for (; i < m && j < n;) { // 以其中一个数组遍历完成为结束条件
    if ( nums1[i] > nums2[j] ) { // 比较当前数值大小
      move(i); // 若nums2中的数值较小，则将num1中当前位置开始的数后移一位
      nums1[i++] = nums2[j++]; // 将nums2当前位置的数插入到空出来位置，同时后移遍历用的下标
      m++; // 以上两步操作导致num2长度增加1，予以记录
    } else {
      i++;  // 若nums1中的数较小，则无需任何操作，比较下一个即可
    }
  }

  for (; j < n;) {  // 若之前的循环未将nums2遍历完，说明nums2中剩余的数比nums1中所有的数都打
    nums1[i++] = nums2[j++]; // 此时直接将nums2中剩余的数放在nums1中剩余的空位中即可（题目中说nums1是足够长的）
  }
};
// @lc code=end

