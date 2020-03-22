// 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
// 示例 1:
// 输入: [1,2,3,4,5,6,7] 和 k = 3
// 输出: [5,6,7,1,2,3,4] (l-189)
// 此题要求用 空间复杂度为: O(1) 的算法完成.

// 1. 暴力法. 每次 unshift 一个数组尾部的数字到数组头部, 并且 pop 数组尾部, 直至达到题目的要求.
// 时间复杂度为: O(n²).

var rotate = function(nums, k) {
  if (nums.length < 2) return;
  if (k >= nums.length) k = k % nums.length;
  if (k === 0) return;
  for (let i = 0; i < k; i++) {
    nums.unshift(nums[nums.length - 1]);
    nums.pop();
  }
}

// 2. 三次反转数组, 移动过于浪费时间, 通过交换数组元素中的位置达到目的. 时间复杂度为: O(n).

var rotate = function(nums, k) {
  if (nums.length < 2) return;
  if (k >= nums.length) k = k % nums.length;
  if (k === 0) return;
  reverse(nums, 0, nums.length - 1);
  reverse(nums, 0, k - 1);
  reverse(nums, k, nums.length - 1);
  function reverse(nums, start, end) {
    while (start < end) {
      [nums[start], nums[end]] = [nums[end], nums[start]];
      start++;
      end--;
    }
  }
}