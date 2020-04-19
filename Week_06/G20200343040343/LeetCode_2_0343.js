/*
 * @lc app=leetcode.cn id=91 lang=javascript
 *
 * [91] 解码方法
 *
 * https://leetcode-cn.com/problems/decode-ways/description/
 *
 * algorithms
 * Medium (23.28%)
 * Likes:    346
 * Dislikes: 0
 * Total Accepted:    43.4K
 * Total Submissions: 185.5K
 * Testcase Example:  '"12"'
 *
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 *
 *
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *
 * 示例 1:
 *
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 *
 *
 * 示例 2:
 *
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 *
 *
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */
var numDecodings = function (s) {
  const n = s.length

  const dp = new Array(n + 1)
  dp[n] = 1
  dp[n - 1] = s.charAt(n - 1) !== '0' ? 1 : 0

  for (let i = n - 2; i >= 0; i--)
    if (s.charAt(i) == '0') {
      dp[i] = 0
      continue
    } else
      dp[i] =
        Number(s.substring(i, i + 2)) <= 26 ? dp[i + 1] + dp[i + 2] : dp[i + 1]

  return dp[0]
}
// @lc code=end
