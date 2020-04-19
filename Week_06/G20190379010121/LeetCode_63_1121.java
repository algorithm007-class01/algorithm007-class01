class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rowlen = obstacleGrid.length;
        int collen = obstacleGrid[0].length;
        int[][] dp = new int[rowlen][collen];
        boolean zore = false;
        for(int col = 0; col< collen;col ++){
            if(zore){
                dp[0][col] = 0;
                continue;
            }
            if(obstacleGrid[0][col] == 0){
                dp[0][col] = 1;
            }else{
                zore = true;
                dp[0][col] = 0;
            }
        }
        zore = false;
        for(int row = 0; row < rowlen;row ++){
            if(zore){
                dp[row][0] = 0;
                continue;
            }
            if(obstacleGrid[row][0] == 0){
                dp[row][0] = 1;
            }else{
                zore = true;
                dp[row][0] = 0;
            }
        }
        for(int row = 1;row < rowlen; row ++){
            for(int col = 1;col < collen; col ++){
                if(obstacleGrid[row][col] == 1){
                    dp[row][col] = 0;
                }else{
                    dp[row][col] = dp[row][col-1] + dp[row-1][col];
                }
            }
        }
        return dp[rowlen-1][collen-1];
    }
}