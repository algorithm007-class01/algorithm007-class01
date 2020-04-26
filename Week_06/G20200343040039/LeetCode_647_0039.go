package G20200343040039

func countSubstrings(s string) int {
	result := 0
	strLen := len(s)
	dp := make([][]bool, strLen, strLen)

	for i := 0; i < strLen; i++ {
		dp[i] = make([]bool, strLen, strLen)
	}

	for j := 0; j < strLen; j++ {
		for i := j; i >= 0; i-- {
			if s[i] == s[j] && ((j - i < 2) || dp[i + 1][j - 1]) {
				dp[i][j] = true
				result++
			}
		}
	}

	return result
}