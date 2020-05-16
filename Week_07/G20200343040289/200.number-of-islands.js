/*
 * @lc app=leetcode id=200 lang=javascript
 *
 * [200] Number of Islands
 *
 * https://leetcode.com/problems/number-of-islands/description/
 *
 * algorithms
 * Medium (44.97%)
 * Likes:    4500
 * Dislikes: 165
 * Total Accepted:    592.2K
 * Total Submissions: 1.3M
 * Testcase Example:  '[["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]'
 *
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of
 * islands. An island is surrounded by water and is formed by connecting
 * adjacent lands horizontally or vertically. You may assume all four edges of
 * the grid are all surrounded by water.
 *
 * Example 1:
 *
 *
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * Output: 1
 *
 *
 * Example 2:
 *
 *
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * Output: 3
 *
 */

// @lc code=start
/**
 * @param {character[][]} grid
 * @return {number}
 */
var numIslands = function (grid) {
  if (!grid) return 0

  let count = 0

  let rows = grid.length
  if (rows === 0) return 0

  let columns = grid[0].length

  for (let i = 0; i < rows; i++) {
    for (let j = 0; j < columns; j++) {
      if (grid[i][j] === '1') {
        dfs(grid, rows, columns, i, j)
        count++
      }
    }
  }

  return count
}

function dfs(grid, r, c, i, j) {
  if (i < 0 || j < 0 || i >= r || j >= c || grid[i][j] !== '1') return

  grid[i][j] = '0'
  dfs(grid, r, c, i + 1, j)
  dfs(grid, r, c, i - 1, j)
  dfs(grid, r, c, i, j + 1)
  dfs(grid, r, c, i, j - 1)
}
// @lc code=end
