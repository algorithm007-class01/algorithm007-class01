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

  
package com.dxm.leetcode.editor.cn;
public class NumberOfIslands{
    public static void main(String[] args) {
        Solution solution = new NumberOfIslands().new Solution();
      }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        if (n==0) return 0;
        int m = grid[0].length;
        int res = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (grid[i][j] == '1') {
                    DFSMarking(grid, i, j, n, m);
                    res++;
                }
            }
        }
        return res;
    }


    private void DFSMarking(char[][] grid, int i, int j, int n, int m){
        if (i<0 || j<0 || i>=n || j>=m || grid[i][j] != '1') return;
        grid[i][j] = '2';
        DFSMarking(grid, i+1, j, n, m);
        DFSMarking(grid, i-1, j, n, m);
        DFSMarking(grid, i, j+1, n, m);
        DFSMarking(grid, i, j-1, n, m);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}