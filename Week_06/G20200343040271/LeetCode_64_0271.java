public class MinimumPathSum {

    /**
     * 一维中间状态
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int[] dp = new int[grid[0].length];
        for (int i = grid.length-1; i >=0 ; i--) {
            for (int j = grid[0].length-1; j >=0 ; j--) {
                if(i == grid.length-1 && j != grid[0].length-1){
                    dp[j] = grid[i][j] + dp[j+1];
                }else if(j == grid[0].length-1 && i != grid.length-1){
                    dp[j] = grid[i][j] + dp[j];
                }else if(i != grid.length-1 && j != grid[0].length-1){
                    dp[j] = grid[i][j] + Math.min(dp[j],dp[j+1]);
                }else {
                    dp[j] = grid[i][j];
                }
            }
        }
        return dp[0];
    }

    /**
     * 二维中间状态
     * @param grid
     * @return
     */
    public int minPathSum2(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = grid.length-1; i >= 0; i--) {
            for (int j = grid[0].length-1; j >= 0 ; j--) {
                if(i == grid.length -1 && j != grid[0].length-1){
                    dp[i][j] = grid[i][j] + dp[i][j+1];
                }else if(j == grid[0].length -1 && i != grid.length -1){
                    dp[i][j] = grid[i][j] + dp[i+1][j];
                }else if(i != grid.length -1 && j != grid[0].length -1){
                    dp[i][j] = grid[i][j] + Math.min(dp[i+1][j],dp[i][j+1]);
                }else {
                    dp[i][j] = grid[i][j];
                }
            }
        }
        return dp[0][0];
    }
}