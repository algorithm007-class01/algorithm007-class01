class Solution {
public:
/**/
    vector<vector<string>> solveNQueens(int n) {
       // . 表示空，Q表示皇后，初始化棋盘
       vector<string> board(n, string(n, '.'));
       vector<vector<string>> result;
       backtrack(board, result, 0); 
       return result;
    }

    // 路径：board中小于row的那些行都已经放置皇后
    // 选择列表：第row行的所有列都是放置皇后的选择
    // 结束条件：row超过board最后一行
    void backtrack(vector<string>& board, vector<vector<string>>&result, int row) {
        // 结束条件
        if(row == board.size()){
            result.push_back(board);
            return;
        }

        int n = board[row].size();
        for(int col = 0; col < n; col++) {
            if(!isValid(board, row, col)) {
                continue;
            }
            // 做选择
            board[row][col] = 'Q';
            // 进入下一个选择
            backtrack(board, result, row + 1);
            // 撤销选择
            board[row][col] = '.';
        }
    }

    // 是否可以在board[row][col]放置皇后.
    bool isValid(vector<string>& board, int row, int col) {
        int n = board.size();
        // 检查列是否有皇后冲突.
        for(int i = 0; i < n; i++) {
            if(board[i][col] == 'Q') {
                return false;
            }
        }

        // 检查135度对角线是否有皇后
        for(int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }

        // 检查45度对角线是否有皇后
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
};
