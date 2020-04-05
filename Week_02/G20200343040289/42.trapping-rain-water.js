/*
 * @lc app=leetcode id=42 lang=javascript
 *
 * [42] Trapping Rain Water
 *
 * https://leetcode.com/problems/trapping-rain-water/description/
 *
 * algorithms
 * Hard (47.01%)
 * Likes:    5855
 * Dislikes: 107
 * Total Accepted:    444.5K
 * Total Submissions: 944.4K
 * Testcase Example:  '[0,1,0,2,1,0,1,3,2,1,2,1]'
 *
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 *
 *
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 * In this case, 6 units of rain water (blue section) are being trapped. Thanks
 * Marcos for contributing this image!
 *
 * Example:
 *
 *
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 *
 */

// @lc code=start
/**
 * @param {number[]} height
 * @return {number}
 */
var trap = function(height) {
  if (!height || height.length < 3) return 0;

  let left = 1;
  let right = height.length - 2;
  let leftMax = height[0];
  let rightMax = height[height.length - 1];
  let res = 0;

  while (left <= right) {
    if (leftMax < rightMax) {
      if (leftMax > height[left]) {
        res += leftMax - height[left];
      }
      leftMax = Math.max(leftMax, height[left]);
      left += 1;
    } else {
      if (rightMax > height[right]) {
        res += rightMax - height[right];
      }
      rightMax = Math.max(rightMax, height[right]);
      right -= 1;
    }
  }

  return res;
};
// @lc code=end
