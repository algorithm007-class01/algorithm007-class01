//给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设
//网格的四个边均被水包围。 
//
// 示例 1: 
//
// 输入:
//11110
//11010
//11000
//00000
//
//输出: 1
// 
//
// 示例 2: 
//
// 输入:
//11000
//11000
//00100
//00011
//
//输出: 3
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int n1;
    int n2;
    
    public int numIslands(char[][] grid) {
        n1 = grid.length;
        if (n1 == 0) return 0;
        n2 = grid[0].length;
        if (n2 == 0) return 0;
        int num = 0;
        for (int row = 0; row < n1; row++)
            for (int col = 0; col < n2; ++col) {
                if (grid[row][col] == '1') {
                    num++;
                    dfs(grid, row, col);
                }
            }
        return num;
    }
    
    private void dfs(char[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= n1 || col >= n2 || grid[row][col] != '1')
            return;
        grid[row][col] = 0;
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);
        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
