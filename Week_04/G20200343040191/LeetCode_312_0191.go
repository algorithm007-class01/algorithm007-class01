func maxCoins(nums []int) int {
    n := len(nums) + 2
    newNums := append(append([]int{1}, nums...), []int{1}...)
    dp := make([][]int, n)
    for i := range dp {
        dp[i] = make([]int, n)
    }
    for l := n - 2; l >= 0; l-- {
        for r := l + 2; r < n; r++ {
            for i := l + 1; i < r; i++ {
                dp[l][r] = max(dp[l][r], newNums[l] * newNums[i] * newNums[r] + dp[l][i] + dp[i][r])
            }
        }
    }
    return dp[0][n-1]
}

func max(a, b int) int {
    if a > b {
        return a
    }
    return b 
}
