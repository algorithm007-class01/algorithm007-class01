/**
 * 233.移动零 https://leetcode-cn.com/problems/move-zeroes/
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
// 双指针进行数组满足条件的项移动
var moveZeroes = function(nums) {
  // j 记录 0 项的下标
  let j = 0;
  for (let i = 0; i < nums.length; i++) {
    // 当前项为非 0 项
    if (nums[i] != 0) {
      // 当 j 小于 i 时，说明已经遍历的数组项中存在 0 项，并进行位置互换
      if (j < i) {
        nums[j] = nums[i];
        nums[i] = 0;
      }
      // 记录 0 的指针向后移动
      j++;
    }
  }
  return nums;
};
