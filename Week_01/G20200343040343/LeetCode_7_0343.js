/*
 * @lc app=leetcode.cn id=66 lang=javascript
 *
 * [66] 加一
 */

// @lc code=start
/**
 * @param {number[]} digits
 * @return {number[]}
 */
var plusOne = function(digits) {
  // 1. 后序遍历数组进行+1操作，为10进位则继续循环，不为10就返回
  let i = digits.length - 1
  for (; i >= 0 ; i--) {
    const res = digits[i] + 1
    if (res === 10) {
      digits[i] = 0
    } else {
      digits[i] = res
      break
    }
  }
  return i === -1 ? [1, ...digits] : digits
}
// @lc code=end
