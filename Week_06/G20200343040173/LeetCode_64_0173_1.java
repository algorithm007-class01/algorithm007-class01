/**
 * 64. 最小路径和
 * 
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 * 
 * 解法 1：暴力
 * 最后返回结果是最小路径的和
 * 我们每次向右或者向下走，最小路径和 = 拿当前的值 + min(向右一步，向下一步)
 * cost(i,j)=grid[i][j]+min(cost(i+1,j),cost(i,j+1))
 * 时间复杂度：O(2^m+n)。每次移动最多可以有两种选择。
 * 空间复杂度：O(m+n)。递归的深度是 m+n。
 */

class Solution {
    public int minPathSum(int[][] grid) {
        return calculate(grid, 0, 0);
    }

    public int calculate(int[][] grid, int i, int j) {
        if (i == grid.length || j == grid[0].length) {
            return Integer.MAX_VALUE;
        }

        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return grid[i][j];
        }

        return grid[i][j] + Math.min(calculate(grid, i + 1, j), calculate(grid, i, j + 1));
    }
}