package cxl.study.leetcode;

/**
 * 64. 最小路径和
 * https://leetcode-cn.com/problems/minimum-path-sum/
 */
public class LeetCode_64_MinimumPathSum {

    /**
     * DP方程
     * if i==0 && j>0
     * f(i,j) = f(0,j)+f(0,j-1)
     * <p>
     * if j==0 && i>0
     * f(i,j) = f(i,0)+f(i-1,0)
     * <p>
     * if i>0 && j>0
     * f(i,j) = f(i,j)+min(f(i-1,j),f(i,j-1))
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (i == 0 && j > 0) {
                    grid[i][j] = grid[0][j] + grid[0][j - 1];
                }
                if (j == 0 && i > 0) {
                    grid[i][j] = grid[i][0] + grid[i - 1][0];
                }
                if (i > 0 && j > 0) {
                    grid[i][j] = grid[i][j] + Math.min(grid[i - 1][j], grid[i][j - 1]);
                }
            }
        }
        return grid[m - 1][n - 1];

    }


}
