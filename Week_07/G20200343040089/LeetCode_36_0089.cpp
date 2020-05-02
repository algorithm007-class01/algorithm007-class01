//	Use a 32-bit bit field to represent numbers in the same row, same column, and same box.
class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        vector<int> wow(9, 0);
        int mux1 = 0;
        int mux2 = 0;
        int mux3 = 0;
        int boxIndex = 0;

        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.') continue;
                mux1 = 0x01 << (board[i][j] - '1');
                mux2 = 0x01 << 9 << (board[i][j] - '1');
                mux3 = 0x01 << 9 << 9 << (board[i][j] - '1');
                boxIndex = (i / 3) * 3 + j / 3;
                if ((wow[i] & mux1) != mux1 && (wow[j] & mux2) != mux2 && (wow[boxIndex] & mux3) != mux3) {
                    wow[i] |= mux1;
                    wow[j] |= mux2;
                    wow[boxIndex] |= mux3; 
                } else {
                    return false;
                }
            }
        }

        return true;
    }   
};