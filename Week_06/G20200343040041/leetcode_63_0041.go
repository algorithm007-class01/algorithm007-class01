package G20200343040041

func uniquePathsWithObstacles(obstacleGrid [][]int) int {
	// if obstacleGrid[0][0] == 1 {
	// 	return 0
	// }
	// row, col := len(obstacleGrid), len(obstacleGrid[0])
	// dp := make([][]int, row)
	// for i := range dp {
	// 	dp[i] = make([]int, col)
	// 	if obstacleGrid[i][0] == 1 || (i > 0 && dp[i-1][0] == 0) {
	// 		dp[i][0] = 0
	// 	} else {
	// 		dp[i][0] = 1
	// 	}
	// }
	// for j := range dp[0] {
	// 	if obstacleGrid[0][j] == 1 {
	// 		break
	// 	}
	// 	dp[0][j] = 1
	// }

	// for i := 1; i < row; i++ {
	// 	for j := 1; j < col; j++ {
	// 		if obstacleGrid[i][j] == 0 {
	// 			dp[i][j] = dp[i-1][j] + dp[i][j-1]
	// 		} else {
	// 			dp[i][j] = 0
	// 		}
	// 	}
	// }

	// return dp[row-1][col-1]

	if len(obstacleGrid) == 0 || obstacleGrid[0][0] == 1 {
		return 0
	}
	obstacleGrid[0][0] = 1
	row, col := len(obstacleGrid), len(obstacleGrid[0])

	for i := 1; i < row; i++ {
		if obstacleGrid[i][0] == 0 && obstacleGrid[i-1][0] == 1 {
			obstacleGrid[i][0] = 1
		} else {
			obstacleGrid[i][0] = 0
		}
	}

	for j := 1; j < col; j++ {
		if obstacleGrid[0][j] == 0 && obstacleGrid[0][j-1] == 1 {
			obstacleGrid[0][j] = 1
		} else {
			obstacleGrid[0][j] = 0
		}
	}

	for i := 1; i < row; i++ {
		for j := 1; j < col; j++ {
			if obstacleGrid[i][j] == 0 {
				obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1]
			} else {
				obstacleGrid[i][j] = 0
			}
		}
	}

	return obstacleGrid[row-1][col-1]
}
