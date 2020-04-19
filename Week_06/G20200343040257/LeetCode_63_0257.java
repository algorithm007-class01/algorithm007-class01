package cxl.study.leetcode;

/**
 * 63. 不同路径 II
 * https://leetcode-cn.com/problems/unique-paths-ii/
 */
public class LeetCode_63_UniquePathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (m == 1 && n == 1 && obstacleGrid[0][0] != 1) {
            return 1;
        }

        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        boolean isBlock = false;
        for (int i = 0; i < m; i++) {
            if (isBlock) {
                obstacleGrid[i][0] = 0;
            } else {
                if (obstacleGrid[i][0] == 1) {
                    obstacleGrid[i][0] = 0;
                    isBlock = true;
                } else {
                    obstacleGrid[i][0] = 1;
                }
            }
        }

        isBlock = false;
        for (int j = 1; j < n; j++) {
            if (isBlock) {
                obstacleGrid[0][j] = 0;
            } else {
                if (obstacleGrid[0][j] == 1) {
                    obstacleGrid[0][j] = 0;
                    isBlock = true;
                } else {
                    obstacleGrid[0][j] = 1;
                }
            }
        }

        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[i].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                } else {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                }
            }
        }
        return obstacleGrid[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 0, 0}, {0, 1, 0}, {0, 0, 0}
        };

        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 1) {
                matrix[i][0] = 0;
                break;
            } else {
                matrix[i][0] = 1;
            }
        }

        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 1) {
                matrix[0][j] = 0;
                break;
            } else {
                matrix[0][j] = 1;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int i1 = 0; i1 < matrix[i].length; i1++) {
                System.out.print(matrix[i][i1]);
            }
            System.out.println();
        }


    }

}
