class Solution {
    public boolean isValidSudoku(char[][] board) {
        final HashSet<String> seen = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int cube = (i / 3) * 3 + (j / 3);
                    if (!seen.add(board[i][j] + "in row " + i)
                            || !seen.add(board[i][j] + "in col " + j)
                            || !seen.add(board[i][j] + "in cube " + cube)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}