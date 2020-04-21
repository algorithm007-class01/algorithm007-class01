package com.szp.leetcode.q51_100;

//给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
//
//说明：每次只能向下或者向右移动一步。
//
//示例:
//
//输入:
//[
//  [1,3,1],
//[1,5,1],
//[4,2,1]
//]
//输出: 7
//解释: 因为路径 1→3→1→1→1 的总和最小。
public class A64_minimum_path_sum {
    class Solution {
        public int minPathSum(int[][] grid) {
            if (null == grid || grid.length == 0 || grid[0].length == 0)
                return 0;
            int m = grid.length, n = grid[0].length;
            int[] dp = new int[grid[0].length];
            int res = Integer.MAX_VALUE;
            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    if (j == n - 1)
                        dp[j] = dp[j] + grid[i][j];
                    else
                        if(i == m-1)
                            dp[j] = dp[j+1] + grid[i][j];
                        else
                            dp[j] = Math.min(dp[j], dp[j + 1]) + grid[i][j];
                }
            }
            return dp[0];
        }
    }

    public static void main(String[] args) {
        Solution solution = new A64_minimum_path_sum().new Solution();
        int[][] grid = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(solution.minPathSum(grid));
    }
}

