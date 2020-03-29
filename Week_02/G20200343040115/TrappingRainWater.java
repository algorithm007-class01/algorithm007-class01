//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Mar
//cos 贡献此图。 
//
// 示例: 
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6 
// Related Topics 栈 数组 双指针

  
  package com.Simba.algorithm007class01.leetcode.editor.cn.leetcode.editor.cn;
  public class TrappingRainWater{
      public static void main(String[] args) {
           int res = new TrappingRainWater().new Solution().trap(new int[]{4,2,0,3,4});
          System.out.printf(""+res);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          /**
           * 按列来，plank记录了较小的中的最高的，每次i与左边最高的落差，就是可装的雨
           * @param A
           * @return
           */
    public int trap(int[] A) {
        if(A==null)return 0;

            int i=0;
            int j=A.length-1;
            int p=0;
            int r=0;
            while (i<=j){
               p=Math.max(p,Math.min(A[i],A[j]));
               r+=A[i]<A[j]?(p-A[i++]):(p-A[j--]);
            }
            return r;

        }

      }
//leetcode submit region end(Prohibit modification and deletion)

  }