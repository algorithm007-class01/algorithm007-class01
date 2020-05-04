class Solution {
    int[][] rows = new int[9][10];
    int[][] cols = new int[9][10];
    int[][] boxs = new int[9][10];
    public void solveSudoku(char[][] board) {
        // 初始化判断数组
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.') continue;
                int num = board[i][j] - '0';
                rows[i][num]++;
                cols[j][num]++;
                boxs[(i/3)*3 + j/3][num]++;
            }
        }

        recur(board, 0, 0);
    }

    private boolean recur(char[][] board, int x, int y) {


        for (int i = x; i < 9; ++i, y = 0) {
            for (int j = y; j < 9; ++j) {
                if (board[i][j] != '.') continue;
                for (char k = '1'; k <= '9'; ++k) {
                    if (isValid(board, i, j, k - '0')) {
                        board[i][j] = k;
                        rows[i][k - '0']++;
                        cols[j][k - '0']++;
                        boxs[(i/3)*3 + j/3][k - '0']++;
                        if (recur(board, x, y + 1)) {
                            return true;
                        }
                        rows[i][k - '0']--;
                        cols[j][k - '0']--;
                        boxs[(i/3)*3 + j/3][k - '0']--;
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int x, int y, int num) {
        return rows[x][num] + cols[y][num] + boxs[(x/3)*3 + y/3][num] == 0;
    }
}