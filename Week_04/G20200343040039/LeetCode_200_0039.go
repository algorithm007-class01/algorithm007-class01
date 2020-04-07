package G20200343040039

func numIslands(grid [][]byte) int {
	if grid == nil || len(grid) == 0 {
		return 0
	}

	rowCount := len(grid)
	colCount := len(grid[0])

	numOfIslands := 0

	for row := 0; row < rowCount; row++ {
		for col := 0; col < colCount; col++ {
			if grid[row][col] == '1' {
				numOfIslands++
				queue := list.New()
				queue.PushBack(row*colCount + col)

				for queue.Len() > 0 {
					rowColElement := queue.Front()
					rowCol := queue.Remove(rowColElement).(int)
					r := rowCol / colCount;
					c := rowCol % colCount;
					if (r - 1 >= 0 && grid[r-1][c] == '1') {
						queue.PushBack((r-1) * colCount + c);
						grid[r-1][c] = '0';
					}
					if (r + 1 < rowCount && grid[r+1][c] == '1') {
						queue.PushBack((r+1) * colCount + c);
						grid[r+1][c] = '0';
					}
					if (c - 1 >= 0 && grid[r][c-1] == '1') {
						queue.PushBack(r * colCount + c - 1);
						grid[r][c-1] = '0';
					}
					if (c + 1 < colCount && grid[r][c+1] == '1') {
						queue.PushBack(r * colCount + c + 1);
						grid[r][c+1] = '0';
					}
				}
			}
		}
	}

	return numOfIslands
}