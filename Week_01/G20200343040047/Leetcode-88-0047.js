/**
 * 88. 合并两个有序数组 https://leetcode-cn.com/problems/merge-sorted-array/
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 */
// 时间复杂度 O(n) 空间复杂度 O(1)
var merge_1 = function(nums1, m, nums2, n) {
  // 两个数组进行从后向前比较
  while (m >= 0 && n > 0) {
    // 符合条件项的下标
    let maxNum = m + n;
    // 数组1 高位与数组2 高位进行比较
    if (nums1[m - 1] > nums2[n - 1]) {
      /**
       * 数组1 的后项 比数组2 的后项大时
       * 将主数组的满足条件的值赋值为数组1 后项
       * 数组1 的指针右移一位
       */
      nums1[maxNum - 1] = nums1[m - 1];
      m--;
    } else {
      /**
       * 数组1 的后项 比数组2 的后项相等或者小时
       * 将主数组的满足条件的值赋值为数组2 后项
       * 数组2 的指针右移一位
       */
      nums1[maxNum - 1] = nums2[n - 1];
      n--;
    }
  }
};
// 思路同上 代码简化
var merge_2 = function(nums1, m, nums2, n) {
  let maxNum = m + n;
  while (m >= 0 && n > 0) {
    // 三目运算 nums1[m - 1] > nums2[n - 1] 返回最大的值，并且对相应下标 -- 处理
    nums1[--maxNum] = nums1[m - 1] > nums2[n - 1] ? nums1[--m] : nums2[--n];
  }
};
