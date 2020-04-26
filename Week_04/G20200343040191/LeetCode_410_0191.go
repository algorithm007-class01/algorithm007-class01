func splitArray(nums []int, m int) int {
    n := len(nums)
    // dp[i+1][j+1]定义为数组[0……i]分成j份时得到的最小的分割子数组的最大值
    dp := make([][]int, n + 1)
    for i := range dp {
        dp[i] = make([]int, m + 1)
        for j := range dp[i] {
            dp[i][j] = 2147483647
        }
    }
    // sub[i+1]定义为数组[0……i]的元素和
    sub := make([]int, n + 1)
    for i := 0; i < n; i++ {
        sub[i + 1] = sub[i] + nums[i]
    }
    dp[0][0] = 0
    for i := 1; i <= n; i++ {
        for j := 1; j <= m; j++ {
            for k := 0; k < i; k++ {
                dp[i][j] = min(dp[i][j], max(dp[k][j-1], sub[i] - sub[k]))
            }
        }
    }
    return dp[n][m]
}

func min(a, b int) int {
    if a < b {
        return a
    }
    return b
}

func max(a, b int) int {
    if a > b {
        return a
    }
    return b
}
