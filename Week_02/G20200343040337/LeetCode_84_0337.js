/*
 * @lc app=leetcode.cn id=84 lang=javascript
 *
 * [84] 柱状图中最大的矩形
 */

// @lc code=start
/**
 * @param {number[]} heights
 * @return {number}
 */
var largestRectangleArea = function(heights) {
  let stack = [];
  stack.peak = function () {
    return this[this.length - 1];
  }

  stack.push(-1);
  let max = 0;
  for (let i = 0; i < heights.length; i++) {
    while (stack.peak() != -1 && heights[stack.peak()] >= heights[i]) {
      max = Math.max(max, heights[stack.pop()] * ( i - stack.peak() - 1))
    }
    stack.push(i);
  }
  while (stack.peak() != -1) {
    max = Math.max(max, heights[stack.pop()] * (heights.length - stack.peak() - 1))
  }
  return max;
};
// @lc code=end

