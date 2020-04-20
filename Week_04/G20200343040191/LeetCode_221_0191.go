func maximalSquare(matrix [][]byte) int {
    n := len(matrix)
    if n == 0 {
        return 0
    }
    m := len(matrix[0])
    maxLen := 0
    dp := make([][]int, n + 1)
    for i := range dp {
        dp[i] = make([]int, m + 1)
    }
    for i := 1; i <= n; i++ {
        for j := 1; j <= m; j++ {
            if matrix[i-1][j-1] == '1' {
                dp[i][j] = min(min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1
                maxLen = max(maxLen, dp[i][j])
            }
        }
    }
    return maxLen * maxLen
}

func max(a, b int) int {
    if a > b {
        return a 
    }
    return b
}

func min(a, b int) int {
    if a < b {
        return a 
    }
    return b
}
