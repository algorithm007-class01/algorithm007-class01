
/**
 *给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 */
public class LeetCode_64_0241 {


    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length ==0)
        {return 0;}

        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for(int i = 1; i < grid[0].length; i++){
            dp[0][i] = grid[0][i] + dp[0][i-1];
        }
        for(int j = 1; j < grid.length; j++){
            dp[j][0] = grid[j][0] + dp[j - 1][0];
        }
        for(int i = 1; i < grid.length; i++){
            for(int j = 1; j < grid[0].length; j++){
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
            }
        }

        return dp[grid.length - 1][grid[0].length - 1];
    }


    public static void main(String[] args) {
        LeetCode_64_0241 leetCode = new LeetCode_64_0241();
        int[][]  arr = new int[][]{{1,3,1}, {1,5,1},{4,2,1}};
        System.out.println(leetCode.minPathSum(arr));
    }
}
