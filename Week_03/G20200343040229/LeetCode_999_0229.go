func numRookCaptures(board [][]byte) int {
	dx := []int{-1, 1, 0, 0}
	dy := []int{0, 0, -1, 1}

	for i := 0; i < 8; i++ {
		for j := 0; j < 8; j++ {
			if board[i][j] != 'R' {
				continue
			}

			res := 0
			for k := 0; k < 4; k++ {
				x := i
				y := j
				for {
					x += dx[k]
					y += dy[k]
					if x < 0 || x >= 8 || y < 0 || y >= 8 || board[x][y] == 'B' {
						break
					}
					if board[x][y] == 'p' {
						res++
						break
					}
				}
			}
			return res
		}
	}

	return 0
}