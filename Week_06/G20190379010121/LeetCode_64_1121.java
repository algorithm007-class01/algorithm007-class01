class Solution {
    public int minPathSum(int[][] grid) {
        int rowlen = grid.length;
        int collen = grid[0].length;
        int[][] dp = new int[rowlen][collen];
        dp[0][0] =  grid[0][0];
        for(int i = 1;i < rowlen;i ++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for(int i = 1;i < collen; i ++){
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        for(int row = 1; row < rowlen; row ++){
            for(int col = 1; col < collen; col ++){
                dp[row][col] = Math.min(dp[row][col-1],dp[row-1][col]) + grid[row][col];
            }
        }
        return dp[rowlen-1][collen-1];
    }
}