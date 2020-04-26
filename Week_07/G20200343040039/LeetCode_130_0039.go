package G20200343040039

type UnionFind struct {
	Parents []int
}

func NewUnionFind(totalNodes int) *UnionFind {
	uf := &UnionFind{
		Parents: make([]int, totalNodes),
	}

	for i := 0; i < totalNodes; i++ {
		uf.Parents[i] = i
	}

	return uf
}

func (uf *UnionFind) union(node1 int, node2 int)  {
	root1 := uf.find(node1)
	root2 := uf.find(node2)

	if root1 != root2 {
		uf.Parents[root2] = root1
	}
}

func (uf *UnionFind) find(node int) int {
	for uf.Parents[node] != node {
		uf.Parents[node] = uf.Parents[uf.Parents[node]]
		node = uf.Parents[node]
	}

	return node
}

func (uf *UnionFind) isConnected(node1 int, node2 int) bool {
	return uf.find(node1) == uf.find(node2)
}

func solve(board [][]byte) {
	if board == nil || len(board) == 0 {
		return
	}

	rows := len(board)
	cols := len(board[0])

	uf := NewUnionFind(rows * cols + 1)

	dummyNode := rows * cols

	for i := 0; i < rows; i++ {
		for j := 0; j < cols; j++ {
			if board[i][j] == 'O' {
				if i == 0 || i == rows - 1 || j == 0 || j == cols - 1 {
					uf.union(node(i, j, board), dummyNode)
				} else {
					if i > 0 && board[i - 1][j] == 'O' {
						uf.union(node(i, j, board), node(i - 1, j, board))
					}

					if i < rows - 1 && board[i + 1][j] == 'O' {
						uf.union(node(i, j, board), node(i + 1, j, board))
					}

					if j > 0 && board[i][j - 1] == 'O' {
						uf.union(node(i, j, board), node(i, j - 1, board))
					}

					if j < cols - 1 && board[i][j + 1] == 'O' {
						uf.union(node(i, j, board), node(i, j + 1, board))
					}
				}
			}
		}
	}

	for i := 0; i < rows; i++ {
		for j := 0; j < cols; j++ {
			if uf.isConnected(node(i, j, board), dummyNode) {
				board[i][j] = 'O'
			} else {
				board[i][j] = 'X'
			}
		}
	}
}

func node(i int, j int, board [][]byte) int {
	return i * len(board[0]) + j
}
