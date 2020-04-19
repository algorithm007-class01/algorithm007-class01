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


package com.Simba.algorithm007class01.leetcode.editor.cn.leetcode.editor.cn;

public class NumberOfIslands {
    public static void main(String[] args) {
        Solution solution = new NumberOfIslands().new Solution();
      //  char[][] a = new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        char[][] a=new char[][]{{}};
        int c = solution.numIslands(a);
        System.out.printf(" " + c);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int m=0;int n=0;
        public int numIslands(char[][] grid) {
            if(grid==null || grid.length==0)return 0;
           m=grid.length;
           n=grid[0].length;
           int count=0;
           for(int i=0;i<m;i++){
               for(int j=0;j<n;j++){
                   if(grid[i][j]=='1'){
                      count++;
                      dfs(grid,i,j);
                   }
               }
           }
           return count;

        }

        private void dfs(char[][] grid, int r, int c) {
            if(r<0 || c<0 || r>=m || c>=n || grid[r][c]=='0') return;
            grid[r][c]='0';
            dfs(grid,r-1,c);
            dfs(grid,r+1,c);
            dfs(grid,r,c-1);
            dfs(grid,r,c+1);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}