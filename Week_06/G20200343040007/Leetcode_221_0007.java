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


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        if (n == 0) return 0;
        int[] dp = new int[n + 1];
        int prev = 0;
        int result = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 1; j < n + 1; ++j)
                if (matrix[i][j - 1] == '1') {
                    dp[j] = Math.min(Math.min(prev, prev = dp[j]), dp[j - 1]) + 1;
                    result = Math.max(result, dp[j]);
                } else dp[j] = 0;
            prev = 0;
        }
        return result * result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
