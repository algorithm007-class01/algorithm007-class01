/**
 * 42. 接雨水 https://leetcode-cn.com/problems/trapping-rain-water/
 */
/**
 * @param {number[]} height
 * @return {number}
 */
var trap = function(height) {
  let stack = [],
    current = 0,
    total = 0;
  while (current < height.length) {
    while (stack.length && height[current] > height[stack[stack.length - 1]]) {
      let top = stack[stack.length - 1];
      stack.pop();
      if (!stack.length) break;
      let width = current - stack[stack.length - 1] - 1;
      let ht =
        Math.min(height[current], height[stack[stack.length - 1]]) -
        height[top];
      total += width * ht;
    }
    stack.push(current++);
  }
  return total;
};
