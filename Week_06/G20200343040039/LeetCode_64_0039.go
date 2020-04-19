package G20200343040039

func minPathSum(grid [][]int) int {
	row := len(grid)
	col := len(grid[0])

	for i := 0; i < row; i++ {
		for j := 0; j < col; j++ {
			if i == 0 && j == 0 {
				continue
			} else if i == 0 {
				grid[i][j] = grid[i][j-1] + grid[i][j]
			} else if j == 0 {
				grid[i][j] = grid[i - 1][j] + grid[i][j]
			} else {
				grid[i][j] = int(math.Min(float64(grid[i][j -1]), float64(grid[i - 1][j]))) + grid[i][j]
			}
		}
	}

	return grid[row - 1][col - 1]
}
