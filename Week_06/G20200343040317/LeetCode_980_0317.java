class Solution {
    int[][] directions = {{1, 0,}, {0, 1}, {-1, 0}, {0, -1}};
    int path = 0;

    public int uniquePathsIII(int[][] grid) {
        int startRow = 0, startCol = 0;
        int workNodeCount = 1;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 1) {
                    startRow = row;
                    startCol = col;
                }
                if (grid[row][col] == 0) {
                    workNodeCount++;
                }
            }
        }
        dfs(grid, startRow, startCol, workNodeCount);
        return path;
    }

    private void dfs(int[][] grid, int row, int col, int workNodeCount) {
        // 终结条件
        if (row >= grid.length || row < 0 || col >= grid[row].length || col < 0 || grid[row][col] == -1 || workNodeCount < 0) {
            return;
        }
        if (grid[row][col] == 2 && workNodeCount != 0) {
            return;
        }
        if (grid[row][col] == 2 && workNodeCount == 0) {
            path++;
            return;
        }


        grid[row][col] = -1;
        for (int[] d : directions) {
            dfs(grid, row + d[0], col + d[1], workNodeCount - 1);
        }
        grid[row][col] = 0;
    }
}