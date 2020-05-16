//52. N皇后 II

class Solution {
private:
    int size, count;
public:
    void solve(int row, int pie, int na) {
        if (row == size) {
            count++;
            return;
        }
        int bits = size & (~(row | pie | na));
        while (bits != 0) {
            int p = bits & (-bits);
            bits -= p; //bits &= bits - 1
            solve(row | p, (pie | p) << 1, (na | p) >> 1);
        }
    }
    int totalNQueens(int n) {
        count = 0; 
        size = (1 << n) - 1; 
        solve(0, 0, 0); 
        return count;         
    }
};