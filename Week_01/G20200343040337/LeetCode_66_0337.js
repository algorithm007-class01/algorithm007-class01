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
  let last = digits.length - 1;
  for (; last >= 0; last--) {
    let tmp = digits[last] + 1
    if ( 10 == tmp ) {
      digits[last] = 0;
    } else {
      digits[last] = tmp;
      break;
    } 
  }

  if (last < 0) {
    digits.unshift(1);
  }
  return digits;
};
// @lc code=end

