/*
 * @lc app=leetcode.cn id=221 lang=java
 *
 * [221] 最大正方形
 */

// @lc code=start
class Solution {
    public int maximalSquare(char[][] matrix) {
        // dp(i, j) = min(dp(i - 1, j), dp(i - 1, j - 1), dp(i, j - 1)) + 1
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int[][] dp = new int[rows + 1][cols + 1];
        int maxlen = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; i <= cols; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    maxlen = Math.max(maxlen, dp[i][j]);
                }
            }
        }

        return maxlen * maxlen;

        // int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        // int[][] dp = new int[rows + 1][cols + 1];
        // int maxsqlen = 0;
        // for (int i = 1; i <= rows; i++) {
        //     for (int j = 1; j <= cols; j++) {
        //         if (matrix[i-1][j-1] == '1'){
        //             dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
        //             maxsqlen = Math.max(maxsqlen, dp[i][j]);
        //         }
        //     }
        // }
        // return maxsqlen * maxsqlen;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(new Solution().maximalSquare(matrix));
    }
}
// @lc code=end

