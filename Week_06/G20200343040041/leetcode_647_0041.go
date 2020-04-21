package G20200343040041

func countSubstrings(s string) int {
	dp := make([][]bool, len(s))
	for i := range dp {
		dp[i] = make([]bool, len(s))
	}
	var res int
	//状态转移方程 dp[i][j] = (s[i] == s[j]) and dp[i + 1][j - 1]
	for j := 0; j < len(s); j++ {
		for i := j; i >= 0 ; i-- {
			if s[i] == s[j] && (j-i <2 || dp[i+1][j-1]) {
				dp[i][j] = true
				res++
			}
		}
	}
	return res
}
