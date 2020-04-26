package G20200343040041

var row, column int

func numIslands(grid [][]byte) int {
	var count int
	if len(grid) == 0 {
		return 0
	}
	row, column = len(grid)-1, len(grid[0])-1
	for i := 0; i <= row; i++ {
		for j := 0; j <= column; j++ {
			if grid[i][j] == '1' {
				dfs(grid, i, j)
				count++
			}
		}
	}
	return count
}

func dfs(grid [][]byte, i, j int) {
	if i < 0 || j < 0 || i > row || j > column || grid[i][j] != '1' {
		return
	}
	grid[i][j] = '0'
	dfs(grid, i-1, j)
	dfs(grid, i+1, j)
	dfs(grid, i, j-1)
	dfs(grid, i, j+1)
}
