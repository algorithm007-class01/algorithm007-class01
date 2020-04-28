class Solution {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        solver(board);
    }

    private boolean solver(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char ch = '1'; ch <= '9'; ch++) {
                        if (valid(board, i, j, ch)) {
                            board[i][j] = ch;
                            if (solver(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    // 1~9 重试完了，还没有false
                    return false;
                }
            }
        }
        return true;
    }


    private boolean valid(char[][] board, int r, int c, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[r][i] != '.' && board[r][i] == num) {
                return false;
            }
            if (board[i][c] != '.' && board[i][c] == num) {
                return false;
            }
            int row = 3 * (r / 3) + i / 3;
            int col = 3 * (c / 3) + i % 3;
            if (board[row][col] != '.' && board[row][col] == num) {
                return false;
            }
        }
        return true;
    }
}