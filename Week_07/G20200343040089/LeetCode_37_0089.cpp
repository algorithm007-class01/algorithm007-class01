//	Backward pruning to solve Sudoku
class Solution {
public:
    void solveSudoku(vector<vector<char>>& board) {
        if (board.size() == 0) return ;
        solve(board);
    }
private:
    bool solve(vector<vector<char>>& board) {
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; ++c) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (solve(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    bool isValid(vector<vector<char>>& board, int row, int col, char c) {
        for (int i = 0; i < 9; ++i) {
            if (board[i][col] != '.' && board[i][col] == c) return false;
            if (board[row][i] != '.' && board[row][i] == c) return false;
            if (board[(row / 3) * 3 + i / 3][(col / 3) * 3 + i % 3] != '.' && \
                board[(row / 3) * 3 + i / 3][(col / 3) * 3 + i % 3] == c) return false;
        }
        return true;
    }
};