//给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 示例: 
//
// 输入:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 7
//解释: 因为路径 1→3→1→1→1 的总和最小。
// 
// Related Topics 数组 动态规划

  
  package com.Simba.algorithm007class01.leetcode.editor.cn.leetcode.editor.cn;
  public class MinimumPathSum{
      public static void main(String[] args) {
           Solution solution = new MinimumPathSum().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minPathSum(int[][] grid) {
        if(grid.length==0)return 0;
       int r=grid.length;
       int c=grid[0].length;
       for(int i=0;i<r;i++){
           for(int j=0;j<c;j++){
               if(i==0 && j==0)continue;
               int leftsum=(j>0)?grid[i][j-1]:Integer.MAX_VALUE;
               int topsum=(i>0)?grid[i-1][j]:Integer.MAX_VALUE;
               grid[i][j]+=Math.min(leftsum,topsum);
           }
       }
       return grid[r-1][c-1];

    }


      }
//leetcode submit region end(Prohibit modification and deletion)

  }