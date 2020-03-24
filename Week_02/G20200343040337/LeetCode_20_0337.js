/*
 * @lc app=leetcode.cn id=20 lang=javascript
 *
 * [20] 有效的括号
 */

// @lc code=start
/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function(s) {
  if (!s) return true;

  function isMatch(a, b) {
    switch (a) {
      case '(':
        return ')' === b;
      case '{':
        return '}' === b;
      case '[':
        return ']' === b;
      default:
        return false;
    }
  }
  let tmp = [];
  for (let idx = 0; idx < s.length; idx++) {
    if (isMatch(tmp[tmp.length - 1], s[idx])) {
      tmp.pop()
    } else {
      tmp.push(s[idx])
    }
  }

  return 0 === tmp.length;
};
// @lc code=end

