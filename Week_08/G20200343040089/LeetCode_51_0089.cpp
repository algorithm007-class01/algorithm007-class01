//	Use bit arithmetic to determine the legal position
class Solution {
public:
    vector<vector<string>> solveNQueens(int n) {
        if (n <= 0) return result;
        size = (1 << n) - 1;
        vector<string> nQueens(n, string(n, '.'));
        solve(nQueens, n, 0, 0, 0, 0);
        return result;
    }
    void solve(vector<string>& nQueens, int n, int row, int col, int ld, int rd) {
        if (row >= n) {
            result.push_back(nQueens);
            return ;
        }

        int bits = size & (~(col | ld | rd));
        while (bits != 0) {
            int bit = bits & (-bits);
            bits &= (bits - 1);
            // 计算第几位是1，用对数函数log2十分方便
            nQueens[row][log2(bit)] = 'Q';
            solve(nQueens, n, row + 1, col | bit, (ld | bit) << 1, (rd | bit) >> 1);
            nQueens[row][log2(bit)] = '.';
        }
    }
private:
    int size;
    vector<vector<string>> result;
};