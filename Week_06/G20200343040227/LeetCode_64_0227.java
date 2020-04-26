package week6.lesson12.p4.homework;

/**
 * 64. 最小路径和
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 */
public class LeetCode_64_0227 {

    public int minPathSum(int[][] grid) {
        //method1 暴力法 递归
//        return method1(grid);
        //动态规划
//        return method2(grid);
        return method3(grid);
    }

    private int method3(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[] dp = new int[col];
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                if (i == row - 1 && j != col - 1)
                    dp[j] = grid[i][j] + dp[j + 1];
                else if (j == col - 1 && i != row - 1)
                    dp[j] = grid[i][j] + dp[j];
                else if (j != col - 1 && i != row - 1)
                    dp[j] = grid[i][j] + Math.min(dp[j], dp[j + 1]);
                else
                    dp[j] = grid[i][j];
            }
        }
        return dp[0];


    }

    private int method2(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                if (i == row - 1 && j != col - 1) {
                    dp[i][j] = grid[i][j] + dp[i][j + 1];
                } else if (i != row - 1 && j == col - 1) {
                    dp[i][j] = grid[i][j] + dp[i + 1][j];
                } else if (j != col - 1 && i != row - 1) {
                    dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
                } else {
                    dp[i][j] = grid[i][j];
                }
            }
        }
        return dp[0][0];
    }

    public int method1(int[][] grid) {
        return helper(grid, 0, 0);
    }

    private int helper(int[][] grid, int i, int j) {
        if (i == grid.length || j == grid[0].length) return Integer.MAX_VALUE;
        if (i == grid.length - 1 && j == grid[i].length - 1) return grid[i][j];
        return grid[i][j] + Math.max(helper(grid, i, j + 1), helper(grid, i + 1, j));

    }
}
