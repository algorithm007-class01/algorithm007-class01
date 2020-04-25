package G20200343040039

import "math"

func maximalSquare(matrix [][]byte) int {
	if matrix == nil {
		return 0
	}
	rows := len(matrix)

	var cols int
	if rows == 0 {
		cols = 0
	} else {
		cols = len(matrix[0])
	}


	dp := make([]int, cols + 1)

	maxSquareLen := 0
	prev := 0

	for i := 1; i <= rows; i++ {
		for j := 1; j <= cols; j++ {
			temp := dp[j]
			if matrix[i-1][j-1] == '1' {
				minPrev := int(math.Min(float64(dp[j - 1]), float64(prev)))
				dp[j] = int(math.Min(float64(minPrev), float64(dp[j]))) + 1
				maxSquareLen = int(math.Max(float64(maxSquareLen), float64(dp[j])))
			} else {
				dp[j] = 0
			}
			prev = temp
		}
	}

	return maxSquareLen * maxSquareLen
}