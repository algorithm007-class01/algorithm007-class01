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
  let len = nums.length;
  k = k % len; // 因为移动数组长度的整数倍没有意义，此处取余
  if (len < 2 || k == 0) return nums; // 处理数组长度不足2 或 移动此处为0的情况

  var move = function (start, nums) {
    // 定义函数用于将数组从开始位置起，每项移动到要求的新位置，然后移动新位置上的数，直至回到起点start
    for ( let i = start, tar = nums[start], cur = nums[start], idx = -1; 1; ) {
      idx = (i + k) % len;
      cur = tar;
      tar = nums[idx];
      nums[idx] = cur;
      i = idx;
      if (idx == start) break;
    }
  };

  var gcd = function (a, b) { // 定义函数，用于获取最大公约数
    return 0 == b ? a : gcd(b, a % b);
  }
  
  let gcdOfLenAndK = gcd(len, k);
  for (let i = 0; i < gcdOfLenAndK; i++) { // 用k和len的最大公约数来保证所有数都被移动
    move(i, nums);
  }
};
// @lc code=end

