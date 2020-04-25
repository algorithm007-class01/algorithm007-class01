//给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 示例: 
//
// 输入:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 7
//解释: 因为路径 1→3→1→1→1 的总和最小。
// 
// Related Topics 数组 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        if (n == 0) return 0;
        int[] dp = new int[n + 1];
        for (int i = 1; i < n + 1; ++i)
            dp[i] = grid[0][i - 1] + dp[i - 1];
        dp[0] = Integer.MAX_VALUE;
        for (int i = 1; i < m; ++i)
            for (int j = 1; j < n + 1; ++j)
                dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j - 1];
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
