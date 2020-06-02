/*
*最小路径和 
*/
class Solution {
    /*
     *时间复杂度:O(m*n)
     *空间复杂度:O(1)
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if(m == 0){
            return 0;
        }
        int n = grid[0].length;
        for(int i = 0;i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j != 0){
                    grid[i][j] = grid[i][j] + grid[i][j - 1];
                }else if(i != 0 && j == 0){
                    grid[i][j] = grid[i][j] + grid[i -1][j];
                }else if(i != 0 && j != 0){
                    grid[i][j] = Math.min(grid[i][j] + grid[i][j - 1], grid[i][j] + grid[i - 1][j]);
                }
            }
        }
        return grid[m - 1][n - 1];
    }
}