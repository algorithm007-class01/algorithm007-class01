/*
 * @lc app=leetcode id=64 lang=javascript
 *
 * [64] Minimum Path Sum
 *
 * https://leetcode.com/problems/minimum-path-sum/description/
 *
 * algorithms
 * Medium (51.11%)
 * Likes:    2531
 * Dislikes: 54
 * Total Accepted:    373.9K
 * Total Submissions: 706.9K
 * Testcase Example:  '[[1,3,1],[1,5,1],[4,2,1]]'
 *
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Example:
 *
 *
 * Input:
 * [
 * [1,3,1],
 * ⁠ [1,5,1],
 * ⁠ [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 *
 *
 */

// @lc code=start
/**
 * @param {number[][]} grid
 * @return {number}
 */
var minPathSum = function (grid) {
  if (!grid) return 0

  let r = grid.length
  if (r === 0) return 0
  let c = grid[0].length

  let f = new Array(r)
  for (let i = 0; i < r; i++) {
    f[i] = new Array(c).fill(0)
  }

  f[0][0] = grid[0][0]

  for (let i = 1; i < r; i++) f[i][0] = grid[i][0] + f[i - 1][0]
  for (let i = 1; i < c; i++) f[0][i] = grid[0][i] + f[0][i - 1]

  for (let i = 1; i < r; i++) {
    for (let j = 1; j < c; j++) {
      f[i][j] = grid[i][j] + Math.min(f[i - 1][j], f[i][j - 1])
    }
  }

  return f[r - 1][c - 1]
}
// @lc code=end
