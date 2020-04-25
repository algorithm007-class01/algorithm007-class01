/*
 * @lc app=leetcode id=91 lang=javascript
 *
 * [91] Decode Ways
 *
 * https://leetcode.com/problems/decode-ways/description/
 *
 * algorithms
 * Medium (23.73%)
 * Likes:    2283
 * Dislikes: 2519
 * Total Accepted:    362.2K
 * Total Submissions: 1.5M
 * Testcase Example:  '"12"'
 *
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping:
 *
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 *
 *
 * Given a non-empty string containing only digits, determine the total number
 * of ways to decode it.
 *
 * Example 1:
 *
 *
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 *
 *
 * Example 2:
 *
 *
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2
 * 6).
 *
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */
var numDecodings = function (s) {
  if (!s) return 0

  let n = s.length
  let f = new Array(n + 1).fill(0)

  f[0] = 1
  f[1] = s[0] === '0' ? 0 : 1

  for (let i = 2; i <= n; i++) {
    let a = parseInt(s.substring(i - 1, i))
    let b = parseInt(s.substring(i - 2, i))

    if (0 < a && a < 10) f[i] += f[i - 1]
    if (9 < b && b < 27) f[i] += f[i - 2]
  }

  return f[n]
}
// @lc code=end
