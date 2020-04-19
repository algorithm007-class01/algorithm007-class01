class Solution {
    private int n;
    private int m;
    boolean[][] visited;
    char[][] grid;

    public int numIslands(char[][] grid) {
        if (grid == null) return 0;
        n = grid.length;
        if (n == 0) return 0;
        m = grid[0].length;
        visited = new boolean[n][m];
        this.grid = grid;
        int count = 0;
 
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == '1') {
                    dfs(i, j);
                    count++;
                }
            }
        }
        return count;

    }

    private void dfs(int i, int j) {

        grid[i][j] = '0';
        visited[i][j] = true;
        if (inLegalArea(i + 1, j)) {
            dfs(i + 1, j);
        }
        if (inLegalArea(i - 1, j)) {
            dfs(i - 1, j);
        }
        if (inLegalArea(i, j + 1)) {
            dfs(i, j + 1);
        }
        if (inLegalArea(i, j - 1)) {
            dfs(i, j - 1);
        }
    }

    private boolean inLegalArea(int i, int j) {
        if (i >= 0 && i < n && j >= 0 && j < m && !visited[i][j] && grid[i][j] != '0') {
            return true;
        } else {
            return false;
        }
    }
}