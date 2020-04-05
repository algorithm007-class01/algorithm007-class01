public class LeetCode200 {
    private int n;
    private int m;

    public int numIslands(char[][] grid) {
        int count = 0;
        n = grid.length;
        if (n == 0) {
            return 0;
        }
        m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    ++count;
                }
            }
        }
        return count;
    }

    /**
     * 将1自身以及附近全部赋为0
     * @param grid
     * @param i
     * @param j
     */
    private void dfs(char[][] grid, int i, int j) {
        // 只对有效边界和有效值做深度优先遍历
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '0';
        // 查询南是否为1
        dfs(grid, i + 1, j);
        // 查询北是否为1
        dfs(grid, i - 1, j);
        // 查询东是否为1
        dfs(grid, i, j + 1);
        // 查询西是否为1
        dfs(grid, i, j - 1);
    }
}
