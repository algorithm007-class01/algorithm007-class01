type point struct {
	x int
	y int
}

func maxDistance(grid [][]int) int {
	size, subSize := len(grid), len(grid[0])
	if size == 0 {
		return 0
	}

	count, group := 0, []*point{}
	for i := 0; i < size; i++ {
		for j := 0; j < subSize; j++ {
			if grid[i][j] != 1 {
				continue
			}
			group = append(group, &point{x: i, y: j})
		}
	}

	groupSize := len(group)
	if groupSize == 0 || groupSize == size * subSize {
		return -1
	}

	for groupSize != 0 {
		count++
		temp := group
		group = []*point{}
		for _, val := range temp {
			i := val.x
			j := val.y
			if i-1 >= 0 && grid[i - 1][j] == 0 {
                grid[i - 1][j] = 1
                group = append(group, &point{x: i - 1, y: j})
            }
            if i < size - 1 && grid[i + 1][j] == 0 {
                grid[i+1][j] = 1
                group = append(group, &point{x: i + 1, y: j})
            }
            if j >= 1 && grid[i][j - 1] == 0 {
                grid[i][j - 1] = 1
                group = append(group, &point{x: i,y: j - 1})
            }
            if j < subSize - 1 && grid[i][j + 1] == 0 {
                grid[i][j + 1] = 1
                group = append(group, &point{x: i,y: j+1})
            }
		}
	}

	return count - 1
}