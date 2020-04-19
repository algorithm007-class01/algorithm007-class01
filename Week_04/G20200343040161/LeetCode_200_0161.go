package G20200343040161

func numIslands(grid [][]byte) int {
	if grid == nil {
		return 0
	}
	if len(grid) == 0 {
		return 0
	}

	result := 0
	m, n := len(grid), len(grid[0])
	marked := make([][]bool, m)
	for i := 0; i < m; i++ {
		tmp := make([]bool, n)
		marked[i] = tmp
	}
	directions := [][]int{ {1, 0}, {0, 1}, {-1, 0}, {0, -1}}
	inArea := func(i, j int) bool {
		if i < 0 || i >= m || j < 0 || j >= n {
			return false
		} else {
			return true
		}
	}
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if grid[i][j] == '1' && !marked[i][j] {
				result++
				queue := make([][2]int, 0)
				// 记得要在入队列时就将坐标标记为已访问，避免大量重复访问
				queue = append(queue, [2]int{i, j})
				marked[i][j] = true
				for len(queue) != 0 {
					cur := queue[0]
					queue = queue[1:]
					// 上下左右四个方向分别遍历
					for _, dir := range directions {
						x, y := cur[0]+dir[0], cur[1]+dir[1]
						// 不越界、未访问过、是陆地的临边节点，需要加入队列，后续进行处理
						if inArea(x, y) && !marked[x][y] && grid[x][y] == '1'{
							queue = append(queue, [2]int{x, y})
							// 记得同样也要在入队列时就将坐标标记为已访问，避免大量重复访问
							marked[x][y] = true
						}
					}
				}
			}
		}
	}
	return result
}