/**
 * 200. 岛屿数量
 * 深度优先搜索
 * 遍历二维数组，遇到 1 的时候计数一次，并使用深度优先搜索把周围的相连的“岛屿” 1 都标记为“水“ 0，从而避免重复计数
 * 
 * 复杂度分析
    时间复杂度 : O(M * N)，其中 M 和 N 分别为行数和列数。
    空间复杂度 : 最坏情况下为 O(M*N)，此时整个网格均为陆地，深度优先搜索的深度达到 M*N。
 */
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int numIslands = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '1') {
                    numIslands++;
                    dfs(grid, row, col);
                }
            }
        }

        return numIslands;
    }

    private void dfs(char[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0';
        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);
    }
}