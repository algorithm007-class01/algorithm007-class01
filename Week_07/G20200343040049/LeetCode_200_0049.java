class Solution {
    int[] dx = new int[]{-1, 0, 0, 1};
    int[] dy = new int[]{0, 1, -1, 0};
    int row, col;
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0)
            return 0;
        this.row = grid.length;
        this.col = grid[0].length;
        int count = 0;

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int x, int y) {
        grid[x][y] = '0';
        for (int i = 0; i < 4; ++i) {
            int newx = x + dx[i];
            int newy = y + dy[i];
            if (isValid(newx, newy) && grid[newx][newy] == '1') {
                dfs(grid, newx, newy);
            }
        }
    }

    private boolean isValid(int x, int y) {
        if (x < 0 || x >= row || y < 0 || y >= col) {
            return false;
        }
        return true;
    }
}
