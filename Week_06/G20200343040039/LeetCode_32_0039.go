package G20200343040039

import "math"

func longestValidParentheses(s string) int {
	result := 0;
	dp := make([]int, len(s))

	for i := 1; i < len(s); i++ {
		if s[i] == ')' {
			if (s[i - 1] == '(') {
				if i >= 2 {
					dp[i] = dp[i - 2] + 2
				} else {
					dp[i] = 2
				}

			} else if (i - dp[i - 1] > 0 && s[i - dp[i - 1] - 1] == '(') {
				if (i - dp[i - 1]) >= 2 {
					dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2
				} else {
					dp[i] = dp[i - 1] + 2
				}
			}
			result = int(math.Max(float64(result), float64(dp[i])))
		}
	}
	return result;
}