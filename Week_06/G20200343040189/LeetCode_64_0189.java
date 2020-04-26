//给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
//
// 说明：每次只能向下或者向右移动一步。
//
// Related Topics 数组 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 在推导后面阶段的状态的时候，我们只关心前面阶段的状态值，不关心这个状态是怎么一步一步推导出来的；
     * 某阶段状态一旦确定，就不受之后阶段的决策影响。
     * @param grid 输入的网格
     * @return 到达终点的路径和
     */
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        // 构造一个dp table用来存放当前路径和
        int[][] dp = new int[row][col];
        // 状态转移方程 dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j]
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 初始位置
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else if (i == 0) {
                    dp[i][j] = dp[i][j-1] + grid[i][j];
                } else if (j == 0) {
                    dp[i][j] = dp[i-1][j] + grid[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
                }
            }
        }
        return dp[row-1][col-1];
    }
}

//leetcode submit region end(Prohibit modification and deletion)
