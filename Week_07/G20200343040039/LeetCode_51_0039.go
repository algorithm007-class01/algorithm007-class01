package G20200343040039

import "strings"

func isValid(board [][]rune, i, j int) bool {
	for start := i - 1; start >= 0; start-- {
		if board[start][j] == 'Q' {
			return false
		}
	}

	m, n := i-1, j+1
	for m >= 0 && n < len(board) {
		if board[m][n] == 'Q' {
			return false
		}
		m--
		n++
	}

	m, n = i-1, j-1
	for m >= 0 && n >= 0 {
		if board[m][n] == 'Q' {
			return false
		}
		m--
		n--
	}

	return true
}

func convert(board [][]rune) []string {
	tmp := make([]string, len(board), len(board))
	for i := 0; i < len(board); i++ {
		var builder strings.Builder
		for j := 0; j < len(board[i]); j++ {
			builder.WriteRune(board[i][j])
		}
		tmp[i] = builder.String()
	}
	return tmp
}

func backtrack(row, n int, board [][]rune, res *[][]string) {
	if row == n {
		*res = append(*res, convert(board))
		return
	}

	for c := 0; c < n; c++ {
		if !isValid(board, row, c) {
			continue
		}
		board[row][c] = 'Q'
		backtrack(row+1, n, board, res)
		board[row][c] = '.'
	}
}

func solveNQueens(n int) [][]string {
	var board = make([][]rune, n, n)
	for i := 0; i < n; i++ {
		tmp := make([]rune, n, n)
		for j := 0; j < n; j++ {
			tmp[j] = '.'
		}
		board[i] = tmp
	}
	var result = make([][]string, 0)
	backtrack(0, n, board, &result)
	return result
}
