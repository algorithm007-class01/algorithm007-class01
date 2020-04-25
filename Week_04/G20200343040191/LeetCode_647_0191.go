func countSubstrings(s string) int {
    sLen := len(s)
    res := sLen
    dp := make([][]bool, sLen)
    for i := range dp {
        dp[i] = make([]bool, sLen)
        dp[i][i] = true
        if i < sLen - 1 && s[i+1] == s[i] {
            dp[i][i+1] = true
            res++
        }
    }
    for i := sLen - 3; i >= 0; i-- {
        for j := i + 2; j < sLen; j++ {
            if dp[i+1][j-1] && s[i] == s[j] {
                dp[i][j] = true
                res++
            }
        }
    }
    return res
}
