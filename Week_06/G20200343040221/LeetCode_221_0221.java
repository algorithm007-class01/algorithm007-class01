//在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。 
//
// 示例: 
//
// 输入: 
//
//1 0 1 0 0
//1 0 1 1 1
//1 1 1 1 1
//1 0 0 1 0
//
//输出: 4 
// Related Topics 动态规划

package leetcode.editor.cn;

public class MaximalSquare_221 {
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private final char char1 = '1';

    // 动态规划
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        if (n == 0) {
            return 0;
        }

        int maxLen = 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != char1) {
                    continue;
                }

                int len = 1;
                if (i > 0 && j > 0) {
                    len = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
                dp[i][j] = len;

                if (len > maxLen) {
                    maxLen = len;
                }
            }
        }
        return maxLen * maxLen;
    }

    // 暴力破解法
    public int maximalSquare1(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        if (n == 0) {
            return 0;
        }
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxArea = Math.max(maxArea, getSquareArea(matrix, i, j, m, n));
            }
        }
        return  maxArea;
    }
    private int getSquareArea(char[][] matrix, int x, int y, int m, int n) {
        if (matrix[x][y] != char1) {
            return 0;
        }

        int l = 1;
        while (isChar1(matrix, x, y, m, n, l)) {
            l++;
        }
        return l * l;
    }
    private boolean isChar1(char[][] matrix, int x, int y, int m, int n, int l) {
        if (x + l >= m || y + l >= n) {
            return false;
        }
        for (int i = 0; i <= l; i++) {
            if (matrix[x + l][y + i] != char1) {
                return false;
            }
            if (matrix[x + i][y + l] != char1) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
  