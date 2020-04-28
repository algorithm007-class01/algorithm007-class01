class Solution {
    int count = 0;
    int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int numIslands(char[][] grid) {
        int row = grid.length;
        if (row == 0) {
            return 0;
        }
        int col = grid[0].length;
        if (col == 0) {
            return 0;
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    sweep(grid, i, j);
                }
            }
        }
        return count;
    }

    private void sweep(char[][] grid, int i, int j) {
        if (i >= grid.length || i < 0 || j >= grid[0].length || j < 0 || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        for (int[] d : directions) {
            sweep(grid, i + d[0], j + d[1]);
        }
    }
}