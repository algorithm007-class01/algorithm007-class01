// DFS
func updateBoard(board [][]byte, click []int) [][]byte {
    m := len(board) - 1
    n := len(board[0]) - 1
    row, col := click[0], click[1]
    if board[row][col] == 'M' {
        board[row][col] = 'X'
    } else {
        count := 0
        for i := -1; i < 2; i++ {
            for j := -1; j < 2; j++ {
                if i == 0 && j == 0 {
                    continue
                }
                r, c := row + i, col + j
                if r < 0 || r > m || c < 0 || c > n {
                    continue
                }
                if board[r][c] == 'M' || board[r][c] == 'X' {
                    count++
                }
            }
        }
        if count > 0 {
            board[row][col] = byte(count + '0')
        } else {
            board[row][col] = 'B'
            for i := -1; i < 2; i++ {
                for j := -1; j < 2; j++ {
                    if i == 0 && j == 0 {
                        continue
                    }
                    r, c := row + i, col + j
                    if r < 0 || r > m || c < 0 || c > n {
                        continue
                    }
                    if board[r][c] == 'E' {
                        updateBoard(board, []int{r, c})
                    }
                }
            }
        }
    }
    return board
}

// BFS
func updateBoard(board [][]byte, click []int) [][]byte {
    m := len(board) - 1
    n := len(board[0]) - 1
    queue := make([][]int, 0)
    queue = append(queue, click)
    for len(queue) != 0 {
        cell := queue[0]
        queue = queue[1:]
        row, col := cell[0], cell[1]
        if board[row][col] == 'M' {
            board[row][col] = 'X'
        } else {
            count := 0
            for i := -1; i < 2; i++ {
                for j := -1; j < 2; j++ {
                    if i == 0 && j == 0 {
                        continue
                    }
                    r, c := row + i, col + j
                    if r < 0 || r > m || c < 0 || c > n {
                        continue
                    }
                    if board[r][c] == 'M' || board[r][c] == 'X' {
                        count++
                    }
                }
            }
            if count > 0 {
                board[row][col] = byte(count + '0')
            } else {
                board[row][col] = 'B'
                for i := -1; i < 2; i++ {
                    for j := -1; j < 2; j++ {
                        if i == 0 && j == 0 {
                            continue
                        }
                        r, c := row + i, col + j
                        if r < 0 || r > m || c < 0 || c > n {
                            continue
                        }
                        if board[r][c] == 'E' {
                            queue = append(queue, []int{r, c})
                            board[r][c] = 'B'
                        }
                    }
                }
            }
        }
    }
    return board
}
