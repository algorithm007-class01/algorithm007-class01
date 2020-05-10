class Solution {
    public int minPathSum(int[][] grid) {
        int columes = grid.length;
        int rows = grid[0].length;
        if (grid == null || columes == 0 || rows == 0) {
            return 0;
        }

        for (int i = 0; i < columes; i++) {
            for (int j = 0; j < rows; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                else if (i == 0) {
                    grid[i][j] = grid[i][j-1] + grid[i][j];
                }
                else if (j == 0) {
                    grid[i][j] = grid[i-1][j] + grid[i][j];
                }
                else {
                    grid[i][j] =  Math.min(grid[i][j-1], grid[i-1][j]) + grid[i][j];
                }
            }
        }
        return grid[columes-1][rows-1];
    }
}