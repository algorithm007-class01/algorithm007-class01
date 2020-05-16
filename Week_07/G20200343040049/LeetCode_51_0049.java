class Solution {
    List<List<String>> ans = new ArrayList<>();
    int n;
    int[] queens;
    int[] cols;
    int[] main;
    int[] secondry;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        queens = new int[n];
        cols = new int[n];
        main = new int[2 * n - 1];
        secondry = new int[2 * n - 1];

        backtrack(0);
        return ans;
    }

    private void backtrack(int row) {
        for (int col = 0; col < n; ++col) {
            if (isNotUnderAttack(row, col)) {
                placeQueen(row, col);

                if (row + 1 == n)
                    addResult();
                else backtrack(row + 1);
                removeQueue(row, col);
            }
        }
    }

    private boolean isNotUnderAttack(int row, int col) {
        int count = cols[col] + main[row - col + n - 1] + secondry[row + col];
        return count == 0 ? true : false;
    }

    private void placeQueen(int row, int col) {
        queens[row] = col;
        cols[col] = 1;
        main[row - col + n - 1] = 1;
        secondry[row + col] = 1;
    }

    private void removeQueue(int row, int col) {
        queens[row] = 0;
        cols[col] = 0;
        main[row - col + n - 1] = 0;
        secondry[row + col] = 0;
    }

    private void addResult() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            StringBuilder s = new StringBuilder();
            int col = queens[i];
            for (int j = 0; j < col; ++j)
                s.append(".");
            s.append("Q");
            for (int j = 0; j < n - col - 1; ++j)
                s.append(".");
            list.add(s.toString());
        }
        ans.add(new ArrayList<>(list));
    }
}