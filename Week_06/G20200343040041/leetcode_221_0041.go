package G20200343040041

func maximalSquare(matrix [][]byte) int {
	if len(matrix) == 0 || len(matrix[0]) == 0 {
		return 0
	}
	height, width, maxSide := len(matrix), len(matrix[0]), 0
	dp := make([][]int, height+1)
	for i := range dp {
		dp[i] = make([]int, width+1)
	}

	//TODO 使用1维数组优化
	for i :=0; i < height; i++ {
		for j :=0; j < width; j++ {
			if matrix[i][j] == '1' {
				dp[i+1][j+1] = min(min(dp[i][j], dp[i+1][j]), dp[i][j+1]) + 1
				maxSide = max(maxSide, dp[i+1][j+1]);
			}
		}
	}
	return maxSide*maxSide
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
