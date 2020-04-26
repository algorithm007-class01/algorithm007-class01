package G20200343040039

type UnionFind struct {
	Count int
	Parent []int
	Rank []int
}

func NewUnionFind(grid [][]byte) *UnionFind {
	rows := len(grid)
	cols := len(grid[0])

	uf := &UnionFind{
		Count: 0,
		Parent: make([]int, rows * cols),
		Rank: make([]int, rows * cols),
	}

	for i := 0; i < rows; i++ {
		for j := 0; j < cols; j++ {
			if grid[i][j] == '1' {
				uf.Parent[i * cols + j] = i * cols + j
				uf.Count++
			}

			uf.Rank[i * cols + j] = 0
		}
	}

	return uf
}

func (uf *UnionFind) find(i int) int {
	if uf.Parent[i] != i {
		uf.Parent[i] = uf.find(uf.Parent[i])
	}

	return uf.Parent[i]
}

func (uf *UnionFind) union(x int, y int) {
	rootX := uf.find(x)
	rootY := uf.find(y)

	if rootX != rootY {
		if uf.Rank[rootX] > uf.Rank[rootY] {
			uf.Parent[rootY] = rootX
		} else if uf.Rank[rootX] < uf.Rank[rootY] {
			uf.Parent[rootX] = rootY
		} else {
			uf.Parent[rootY] = rootX
			uf.Rank[rootX] += 1
		}

		uf.Count--
	}
}

func (uf *UnionFind) getCount() int {
	return uf.Count
}

func numIslands(grid [][]byte) int {
	if grid == nil || len(grid) == 0 {
		return 0
	}

	rows := len(grid)
	cols := len(grid[0])
	uf := NewUnionFind(grid)

	for i := 0; i < rows; i++ {
		for j := 0; j < cols; j++ {
			if grid[i][j] == '1' {
				grid[i][j] = '0'

				if i - 1 >= 0 && grid[i - 1][j] == '1' {
					uf.union(i * cols + j, (i - 1) * cols + j)
				}

				if i + 1 < rows && grid[i + 1][j] == '1' {
					uf.union(i * cols + j, (i + 1) * cols + j)
				}

				if j - 1 >= 0 && grid[i][j - 1] == '1' {
					uf.union(i * cols + j, i * cols + j - 1)
				}

				if j + 1 < cols && grid[i][j + 1] == '1' {
					uf.union(i * cols + j, i * cols + j + 1)
				}
			}
		}
	}

	return uf.getCount()
}
