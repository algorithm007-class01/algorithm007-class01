package cxl.study.leetcode;

/**
 * 62. 不同路径
 * https://leetcode-cn.com/problems/unique-paths/
 */
public class LeetCode_62_UniquePaths {

    public int uniquePaths1(int m, int n) {
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            matrix[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            matrix[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
            }
        }
        return matrix[m - 1][n - 1];
    }

    public int uniquePaths2(int m, int n) {
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            matrix[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            matrix[0][i] = 1;
        }

        if (m == 1 || n == 1) {
            return 1;
        }
        findPaths(matrix, 1, 1, m, n);
        return matrix[m - 1][n - 1];
    }


    private void findPaths(int[][] matrix, int i, int j, int m, int n) {

        if (i > m - 1 || j > n - 1) {
            return;
        }
        matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];

        findPaths(matrix, i + 1, j, m, n);
        findPaths(matrix, i, j + 1, m, n);
    }

    public static void main(String[] args) {
        LeetCode_62_UniquePaths uniquePaths = new LeetCode_62_UniquePaths();
        System.out.println(uniquePaths.uniquePaths2(51, 9));
    }

}
