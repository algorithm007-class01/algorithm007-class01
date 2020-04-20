package G20200343040039

type Square struct {
	row int
	col int
}

var adjacentSquareDisplacement = []Square{
	{-1, 0},
	{-1, 1},
	{0, 1},
	{1, 1},
	{1, 0},
	{1, -1},
	{0, -1},
	{-1, -1},
}

func updateBoard(board [][]byte, click []int) [][]byte {
	dfs_recur(board, click[0], click[1])

	return board
}

func dfs_recur(board [][]byte, row int, col int) {
	numberOfRow := len(board)
	numberOfCol := len(board[0])

	if row < 0 || row >= numberOfRow || col < 0 || col >= numberOfCol {
		return
	}

	if board[row][col] == 'E' {
		board[row][col] = 'B'
		numberOfMines := getAdjMinesNumber(board, row, col)

		if numberOfMines == 0 {
			for i := 0; i < 8; i++ {
				dfs_recur(board, row + adjacentSquareDisplacement[i].row, col + adjacentSquareDisplacement[i].col)
			}
		} else {
			board[row][col] = byte(numberOfMines + '0')
		}
	} else if board[row][col] == 'M' {
		board[row][col] = 'X'
	}
}

func getAdjMinesNumber(board [][]byte, squareRow int, squareCol int, ) int {
	row := len(board)
	col := len(board[0])

	minesNumber := 0

	for i := 0; i < 8; i++ {
		adjSquareCoor := adjacentSquareDisplacement[i]
		adjSquareRow := squareRow + adjSquareCoor.row
		adjSquareCol := squareCol + adjSquareCoor.col

		if adjSquareRow < 0 || adjSquareRow >= row || adjSquareCol < 0 || adjSquareCol >= col {
			continue
		}

		if board[adjSquareRow][adjSquareCol] == 'M' {
			minesNumber++
		}
	}

	return minesNumber
}