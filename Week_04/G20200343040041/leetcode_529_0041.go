package G20200343040041

var xys = [8][2]int{{0, -1}, {0, 1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}}

func updateBoard(board [][]byte, click []int) [][]byte {
	if len(board) == 0 {
		return [][]byte{}
	}
	dfs(board, click[0], click[1])
	return board
}

func dfs(board [][]byte, x, y int) {
	row, col := len(board)-1, len(board[0])-1
	if x < 0 || x > col || y < 0 || y > col {
		return
	}
	if board[x][y] == 'M' {
		board[x][y] = 'X'
		return
	}
	if board[x][y] == 'E' {
		board[x][y] = 'B'
		count := judge(board, x, y, row, col)
		if count == 0 {
			for _, xy := range xys {
				newX, newY := x+xy[0], y+xy[0]
				if newX < 0 || newX > col || newY < 0 || newY > row {
					continue
				}
				if board[x][y] == 'E' {
					dfs(board, newX, newY)
				}
			}
		} else {
			board[x][y] = byte(count)
		}
	}
}

func judge(board [][]byte, x, y, row, col int) int {
	var count int
	for _, xy := range xys {
		newX, newY := x+xy[0], y+xy[1]
		if newX < 0 || newX >= col || newY < 0 || newY >= row {
			continue
		}
		if board[newX][newY] == 'M' {
			count++
		}
	}
	return count
}
