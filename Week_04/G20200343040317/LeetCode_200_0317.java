class Solution {
    int n; // 行
    int m;  //列

    public int numIslands(char[][] grid) {
        int count = 0;
        n = grid.length;
        if (n == 0) {
            return count;
        }
        m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 遇到岛屿了
                if (grid[i][j] == '1') {
                    // 岛屿技计数
                    ++count;
                    // 清理岛屿
                    swamp(grid, i, j);
                }

            }
        }
        return count;
    }

    private void swamp(char[][] grid, int i, int j) {
        // i 表示行 j 表示列
        if (i >= n || j >= m || i < 0 || j < 0 || grid[i][j] != '1') {
            // 1 已经出界了
            // 2 已经出岛了
            return;
        }
        if (grid[i][j] == '1') {
            grid[i][j] = '0';
            swamp(grid, i + 1, j);
            swamp(grid, i - 1, j);
            swamp(grid, i, j + 1);
            swamp(grid, i, j - 1);
        }
    }
}