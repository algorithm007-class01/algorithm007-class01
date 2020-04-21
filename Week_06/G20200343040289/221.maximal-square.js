/*
 * @lc app=leetcode id=221 lang=javascript
 *
 * [221] Maximal Square
 *
 * https://leetcode.com/problems/maximal-square/description/
 *
 * algorithms
 * Medium (35.46%)
 * Likes:    2367
 * Dislikes: 61
 * Total Accepted:    199.6K
 * Total Submissions: 558.8K
 * Testcase Example:  '[["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]'
 *
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square
 * containing only 1's and return its area.
 *
 * Example:
 *
 *
 * Input:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * Output: 4
 *
 */

// @lc code=start
/**
 * @param {character[][]} matrix
 * @return {number}
 */
var maximalSquare = function (matrix) {
  if (!matrix) return 0

  let r = matrix.length
  let c = r > 0 ? matrix[0].length : 0

  let f = new Array(r + 1)
  for (let i = 0; i < r + 1; i++) {
    f[i] = new Array(c + 1).fill(0)
  }

  let maxRadius = 0

  for (let i = 1; i < r + 1; i++) {
    for (let j = 1; j < c + 1; j++) {
      if (matrix[i - 1][j - 1] === '1') {
        f[i][j] = Math.min(f[i - 1][j], f[i][j - 1], f[i - 1][j - 1]) + 1
        maxRadius = Math.max(f[i][j], maxRadius)
      }
    }
  }

  return maxRadius * maxRadius
}
// @lc code=end
