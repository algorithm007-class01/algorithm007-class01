package G20200343040039

import "strings"

func solveNQueens(n int) [][]string {
	board := make([][]rune, n, n)

	for i := 0; i < n; i++ {
		tmp := make([]rune, n, n)
		for j := 0; j < n; j++ {
			tmp[j] = '.'
		}
		board[i] = tmp
	}

	result := make([][]string, 0)
	backtrack(0, n, board, &result)

	return result
}

func backtrack(row int, n int, board [][]rune, result *[][]string) {
	if row == n {
		*result = append(*result, convert(board))
		return
	}

	for col := 0; col < n; col++ {
		if !isValid(board, row, col) {
			continue
		}

		board[row][col] = 'Q'
		backtrack(row + 1, n, board, result)
		board[row][col] = '.'
	}

}

func isValid(board [][]rune, row int, col int) bool {
	//判断当前位置以上的同行列有没有已经放了皇后
	for i := row - 1; i >= 0; i-- {
		if board[i][col] == 'Q'{
			return false
		}
	}

	//判断右上是否放置Q
	i := row - 1
	j := col + 1
	for i >= 0 && j < len(board) {
		if board[i][j] == 'Q' {
			return false
		}
		i--
		j++
	}
	//判断左上是否放置Q
	i = row - 1
	j = col - 1
	for i >= 0 && j >= 0 {
		if board[i][j] == 'Q' {
			return false
		}
		i--
		j--
	}

	return true
}

func convert(board [][]rune) []string {
	result := make([]string, len(board), len(board))

	for i := 0; i < len(board); i++ {
		var builder strings.Builder
		for j := 0; j < len(board[i]); j++ {
			builder.WriteRune(board[i][j])
		}
		result[i] = builder.String()
	}

	return result
}