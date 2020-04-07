/*
200. 岛屿数量 链接：https://leetcode-cn.com/problems/number-of-islands
给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。
一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
示例 1:
输入:
    11110
    11010
    11000
    00000
输出: 1

示例 2:
输入:
    11000
    11000
    00100
    00011
输出: 3

*/
public class NumberOfIslands {


    /**
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int x = grid.length;
        int y = grid[0].length;
        int total = 0;
        for (int i = 0; i < x ; i++) {
            for (int j = 0; j < y ; j++) {
                if(grid[i][j] == '1')
                    total++;
                dfs(grid, i, j); // 切换为bfs(grid, i, j)则为广度优先
            }
        }
        return total;
    }

    /**
     * DFS,从0,0这个点出发，向上右下左顺序遍历周围不为0的点，直至所有点改为0，然后开始下一轮查找
     * @param grid
     * @param i
     * @param j
     */
    private void dfs(char[][] grid, int i, int j) {
        if(grid == null || grid.length == 0) return ;
        int x = grid.length;
        int y = grid[0].length;
        if (i < 0 || j < 0 || i >= x || j >= y || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        // 对当前坐标点四周进行查找，按照上右下左
        dfs(grid,i, j + 1);
        dfs(grid,i + 1, j);
        dfs(grid,i, j - 1);
        dfs(grid,i - 1, j);

    }

    /**
     * BFS,从0,0这个点出发，向上右下左顺序遍历周围不为0的点，再次添加周围点，直至所有点改为0，然后开始下一轮查找
     * @param grid
     * @param i
     * @param j
     */
    private void bfs(char[][] grid, int i, int j) {
        Queue<int[]> list = new LinkedList<>();
        list.add(new int[] { i, j });
        while (!list.isEmpty()) {
            int[] curr = list.remove();
            i = curr[0];
            j = curr[1];
            if (i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] == '1') {
                grid[i][j] = '0';
                list.add(new int[]{i, j + 1});
                list.add(new int[]{i + 1, j});
                list.add(new int[]{i, j - 1});
                list.add(new int[]{i - 1, j});
            }
        }
    }
}