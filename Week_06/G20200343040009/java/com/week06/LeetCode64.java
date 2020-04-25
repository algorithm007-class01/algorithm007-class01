package com.week06;

/**
 * 1. 重复子问题 dp(i, j) = grid(i, j) + min(sub(i + 1, j), sub(i, j + 1));
 * 2. 中间状态 grid[i][j]
 * 3. 推导公式：dp[i][j] = grid[i][j] + Math.min(grid[i + 1][j], grid[i][j + 1]);
 *
 * 最小路径
 */
public class LeetCode64 {
    public int minPathSum(int[][] grid) {
        int iLength = grid.length;
        int jLength = grid[0].length;
        int[][] dp = new int[iLength][jLength];
        for (int i = iLength - 1; i >= 0; i--) {
            for (int j = jLength - 1; j >= 0; j--) {
                if (i == iLength - 1 && j != jLength - 1) {
                    dp[i][j] = grid[i][j] + dp[i][j + 1];
                } else if (j == jLength - 1 && i != iLength - 1) {
                    dp[i][j] = grid[i][j] + dp[i + 1][j];
                } else if (i != iLength - 1 && j != jLength - 1) {
                    dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
                } else {
                    dp[i][j] = grid[i][j];
                }
            }
        }
        return dp[0][0];
    }
}
