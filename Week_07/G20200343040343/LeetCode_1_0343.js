/*
 * @lc app=leetcode.cn id=22 lang=javascript
 *
 * [22] 括号生成
 *
 * https://leetcode-cn.com/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (73.61%)
 * Likes:    820
 * Dislikes: 0
 * Total Accepted:    90.6K
 * Total Submissions: 122.9K
 * Testcase Example:  '3'
 *
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 
 * 例如，给出 n = 3，生成结果为：
 * 
 * [
 * ⁠ "((()))",
 * ⁠ "(()())",
 * ⁠ "(())()",
 * ⁠ "()(())",
 * ⁠ "()()()"
 * ]
 * 
 * 
 */

// @lc code=start
/**
 * @param {number} n
 * @return {string[]}
 */
var generateParenthesis = function(n) {
  function recur(left, right, n, s) {
    if (left === n && right === n) {
      res.push(s)
      return
    }
    if (left < n) {
      recur(left + 1, right, n, s + '(')
    }
    if (left > right) {
      recur(left, right + 1, n, s + ')')
    }
  }
  const res = []
  recur(0, 0, n, '')
  return res
};
// @lc code=end

