class Solution {
    List<List<String>> res;
    List<String> resOfRow;
    char[][] board;
    int size, n;

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        resOfRow = new ArrayList<>();
        board = new char[n][n];
        size = (1 << n) - 1;
        this.n = n;

        for (int i = 0; i < n; ++i)
            Arrays.fill(board[i], '.');
        solve(0, 0, 0, 0);
        return res;
    }

    public void solve(int row, int col, int master, int slave) {
        if (col == size) {
            res.add(new ArrayList(resOfRow));
            return;
        }

        int pos = size & (~(col | master | slave));
        while (pos != 0) {
            int p = pos & -pos;
            int colIdx = (int) (Math.log(p) / Math.log(2));
            board[row][colIdx] = 'Q';
            resOfRow.add(new String(board[row]));
            solve(row + 1, col | p, (master | p) << 1, (slave | p) >> 1);
            pos &= (pos - 1);
            board[row][colIdx] = '.';
            resOfRow.remove(resOfRow.size() - 1);
        }
    }
}