package com.szp.leetcode.q151_200;

public class A200_number_of_islands {
    class Solution {
        public int numIslands(char[][] grid) {
            if(null == grid || grid.length == 0 || 0 == grid[0].length)
                return 0;
            int m = grid.length, n = grid[0].length;
            int[][] visited = new int[m][n];
            int nums = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    visited[i][j] = 0;
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if(visited[i][j] == 0){
                        if(grid[i][j] == '1'){
                            nums ++;
                        }
                        search(i,j,grid,visited);
                    }
                }
            }
            return nums;
        }

        private void search(int i, int j, char[][] grid, int[][] visited) {
            if(i < 0 || i == grid.length || j< 0 || j == grid[0].length || grid[i][j] == '0' || visited[i][j] == 1)
                return;
            visited[i][j] = 1;
            search(i-1,j,grid,visited);
            search(i+1,j,grid,visited);
            search(i,j-1,grid,visited);
            search(i,j+1,grid,visited);
        }
    }
/*
* 输入:
11110
11010
11000
00000
输出: 1
*
* 输入:
11000
11000
00100
00011
输出: 3
* */
    public static void main(String[] args) {
        Solution solution = new A200_number_of_islands().new Solution();
        char[][] grid = new char[][]{
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        };
        System.out.println(solution.numIslands(grid));

        char[][] grid2 = new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','0','0'},
                {'1','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println(solution.numIslands(grid2));
    }
}
