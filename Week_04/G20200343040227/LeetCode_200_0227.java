package week4.homework;

/**
 * 200. 岛屿数量
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * <p>
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * <p>
 * 输出: 3
 */
public class LeetCode_200_0227 {
    public int numIslands(char[][] grid) {
        int res = 0;
        int n = grid.length;
        if (n == 0) return 0;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j, grid);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(int n, int m, char[][] grid) {
        if (n < 0 || n >= grid.length || m < 0 || m >= grid.length || grid[n][m] != '1') {
            return;
        }
        grid[n][m] = '0';
        dfs(n + 1, m, grid);
        dfs(n - 1, m, grid);
        dfs(n, m - 1, grid);
        dfs(n, m + 1, grid);
    }
}
