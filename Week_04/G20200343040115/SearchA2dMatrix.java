//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 示例 1: 
//
// 输入:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 13
//输出: false 
// Related Topics 数组 二分查找

  
  package com.Simba.algorithm007class01.leetcode.editor.cn.leetcode.editor.cn;
  public class SearchA2dMatrix{
      public static void main(String[] args) {
           Solution solution = new SearchA2dMatrix().new Solution();
           int[][]matrix={{1},{3}};
           int target=3;
       boolean flage=    solution.searchMatrix(matrix,3);
          System.out.printf(" "+flage);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0)return false;
        int m=matrix.length;
        int n=matrix[0].length;
        int lo=0;int hi=m*n-1;
        while (lo<=hi){
            int mid=(lo+hi)>>1;
            int val=matrix[mid/n][mid%n];
            if(target<val){
                hi=mid-1;
            }else if(target>val){
                lo=mid+1;
            }else{
                return true;
            }
        }
        return false;

    }




      }
//leetcode submit region end(Prohibit modification and deletion)

  }