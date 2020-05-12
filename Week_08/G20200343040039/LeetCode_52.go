package G20200343040039

func totalNQueens(n int) int {
	size := (1 << n) - 1
	count := 0
	solve(0, 0, 0, size, &count)

	return count
}

func solve(row int, ld int, rd int, size int, count *int) {
	if row == size {
		(*count)++
		return
	}

	pos := size & (^(row | ld | rd))

	for pos != 0 {
		p := pos & (-pos)
		pos -= p
		solve(row | p, (ld | p) << 1, (rd | p) >> 1, size, count)
	}
}
