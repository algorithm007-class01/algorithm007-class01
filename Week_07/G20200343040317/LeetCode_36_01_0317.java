class Solution {
    public boolean isValidSudoku(char[][] board) {
        final int[][] row = new int[9][9];
        final int[][] col = new int[9][9];
        final int[][] cube = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int data = board[i][j] - '1';
                    // row check
                    if (row[i][data] == 1) {
                        return false;
                    } else {
                        row[i][data] = 1;
                    }

                    // col check
                    if (col[j][data] == 1) {
                        return false;
                    } else {
                        col[j][data] = 1;
                    }
                    // cube check
                    final int idx = i / 3 * 3 + j / 3;
                    if (cube[idx][data] == 1) {
                        return false;
                    } else {
                        cube[idx][data] = 1;
                    }
                }
            }
        }
        return true;
    }
}
