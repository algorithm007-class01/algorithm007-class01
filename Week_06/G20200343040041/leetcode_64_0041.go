package G20200343040041

func minPathSum(grid [][]int) int {
	if len(grid) == 0 || len(grid[0]) == 0 {
		return 0
	}
	row, col := len(grid), len(grid[0])
	for i := 1; i <row; i++ {
		grid[i][0] += grid[i-1][0]
	}
	for j :=1; j < col; j++ {
		grid[0][j] += grid[0][j-1]
	}
	for i := 1; i < row; i++ {
		for j := 1; j < col; j++ {
			grid[i][j] += min(grid[i-1][j], grid[i][j-1])
		}
	}
	return grid[row-1][col-1]
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}
