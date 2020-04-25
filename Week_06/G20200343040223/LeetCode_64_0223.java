package leetcode;

public class LeetCode_64_0223 {

    public int minPathSum(int[][] grid) {
        int M = grid.length,N = grid[0].length;
        for(int i = 0; i < M;i++){
            for(int j = 0;j < N;j++){
                if(i == 0 && j==0) continue;
                else if(j == 0) grid[i][j] = grid[i - 1][j] + grid[i][j];
                else if(i == 0) grid[i][j] = grid[i][j-1] + grid[i][j];
                else grid[i][j] = grid[i][j] + Math.min(grid[i-1][j],grid[i][j-1]);
            }
        }
        return grid[M-1][N-1];

    }
}
