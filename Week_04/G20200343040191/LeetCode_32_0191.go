func longestValidParentheses(s string) int {
    sLen := len(s)
    if sLen < 2 {
        return 0
    }
    res := 0
    dp := make([]int, sLen)
    if s[0] == '(' && s[1] == ')' {
        dp[1] = 2
        res = 2
    }
    for i := 2; i < sLen; i++ {
        if s[i] == ')' {
            if s[i-1] == '(' {
                dp[i] = dp[i-2] + 2
            } else if dp[i-1] > 0 && i - dp[i-1] - 1 >= 0 && s[i - dp[i-1] - 1] == '(' {
                dp[i] = dp[i-1] + 2
                if i - dp[i-1] - 1 > 0 {
                    dp[i] += dp[i - dp[i-1] - 2]
                }
            }
            res = max(res, dp[i])
        }
    }
    return res
}

func max(a, b int) int {
    if a > b {
        return a
    }
    return b 
}
