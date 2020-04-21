func minPathSum(grid [][]int) int {
    n := len(grid)
    m := len(grid[0])
    dp := make([]int, n)
    dp[0] = grid[0][0]
    for i := 1; i < n; i++ {
        dp[i] = grid[i][0] + dp[i-1]
    }
    for j := 1; j < m; j++ {
        for i := 0; i < n; i++ {
            if i == 0 {
                dp[i] += grid[0][j]
            } else {
                dp[i] = grid[i][j] + min(dp[i], dp[i-1])
            }
        }
    }
    return dp[n-1]
}

func min(a, b int) int {
    if a < b {
        return a 
    }
    return b
}
