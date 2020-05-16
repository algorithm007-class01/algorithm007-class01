//	Use bit arithmetic to determine the legal position
class Solution {
public:
    int totalNQueens(int n) {
        count = 0;
        size = (1 << n) - 1;
        solve(n, 0, 0, 0, 0);
        return count;
    }

    void solve(int n, int row, int col, int ld, int rd) {
        if (row >= n) {
            count++;
            return ;
        }

        int pos = size & (~(col | ld | rd));
        while (pos != 0) {
            int p = pos & (-pos);
            pos = pos & (pos - 1);
            solve(n, row + 1, col | p, (ld | p) << 1, (rd | p) >> 1);
        }
    }
private:
    int count;
    int size;
};