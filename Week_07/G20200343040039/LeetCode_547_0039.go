package G20200343040039

func findCircleNum(M [][]int) int {
	parent := make([]int, len(M))

	for i := 0; i < len(M); i++ {
		parent[i] = -1
	}

	for i := 0; i < len(M); i++ {
		for j := 0; j < len(M); j++ {
			if M[i][j] == 1 && i != j {
				union(parent, i, j)
			}
		}
	}

	count := 0

	for i := 0; i < len(parent); i++ {
		if parent[i] == -1 {
			count++
		}
	}

	return count
}

func union(parent []int, x int, y int) {
	xSet := find(parent, x)
	ySet := find(parent, y)

	if xSet != ySet {
		parent[xSet] = ySet
	}
}

func find(parent []int, i int) int {
	if parent[i] == -1 {
		return i
	}

	return find(parent, parent[i])
}