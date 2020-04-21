package G20200343040039

import "math"

func minDistance(word1 string, word2 string) int {
	n := len(word1)
	m := len(word2)

	if n * m == 0 {
		return n + m
	}

	dp := make([][]int, n + 1)
	for i := 0; i < n+1; i++ {
		dp[i] = make([]int, m + 1)
	}

	for i := 0; i < n + 1; i++ {
		dp[i][0] = i
	}
	for j := 0; j < m + 1; j++ {
		dp[0][j] = j
	}

	for i := 1; i < n + 1; i++ {
		for j := 1; j < m + 1; j++ {
			left := dp[i - 1][j] + 1
			down := dp[i][j - 1] + 1
			left_down := dp[i - 1][j - 1]
			if word1[i - 1] != word2[j - 1] {
				left_down += 1
			}

			dp[i][j] = int(math.Min(float64(left), math.Min(float64(down), float64(left_down))))

		}
	}
	return dp[n][m];
}