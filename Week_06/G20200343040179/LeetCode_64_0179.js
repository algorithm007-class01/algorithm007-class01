var minPathSum = function(grid) {
    const row = grid.length;
    const col = grid[0].length;
    const dp = Array.from(new Array(row),() => new Array(col));
    for(let i = 0; i < row; i++){
        for(let j = 0; j < col; j++){
            if(i === 0 && j === 0){
                dp[i][j] = grid[i][j];
            }else if(i === 0 && j !== 0){
                dp[i][j] = dp[i][j-1]+ grid[i][j];
            }else if(j === 0 && i !== 0){
                dp[i][j] = dp[i-1][j] + grid[i][j];
            }else {
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j]
            }
        }
    }
    return dp[row-1][col-1]
};