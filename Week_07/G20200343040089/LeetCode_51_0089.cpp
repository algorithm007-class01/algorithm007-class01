//	Use the retro pruning method to find a variety of different N queen chessboards
class Solution {
public:
    vector<vector<string>> solveNQueens(int n) {
        vector<vector<string>> result;
        vector<string> nQueens(n, string(n, '.'));
        solveNQueens(result, nQueens, 0, n);
        return result;
    }
private:
    void solveNQueens(vector<vector<string>>& result, vector<string>& nQueens, int row, int n) {
        if (row == n) {
            result.push_back(nQueens);
            return ;
        }
        // 回缩逻辑代码
        for (int col = 0; col != n; ++col) {
            if (isValid(nQueens, row, col, n)) {
                nQueens[row][col] = 'Q';
                solveNQueens(result, nQueens, row + 1, n);
                nQueens[row][col] = '.';
            }
        }
    }
    bool isValid(vector<string>& nQueens, int row, int col, int n) {
        //  判断同一列是否有皇后
        for (int i = 0; i != row; ++i) {
            if (nQueens[i][col] == 'Q') {
                return false;
            }
        }

        //  判断左上角45度斜线上是否有皇后
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; --i, --j) {
            if (nQueens[i][j] == 'Q') {
                return false;
            }
        }

        //  判断右上角45度斜线上是否由皇后
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; --i, ++j) {
            if (nQueens[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
};