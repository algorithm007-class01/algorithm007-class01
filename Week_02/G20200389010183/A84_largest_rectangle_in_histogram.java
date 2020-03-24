package com.szp.leetcode.q51_100;

public class A84_largest_rectangle_in_histogram {
    class Solution {
        public int largestRectangleArea(int[] heights) {
            if(null == heights || heights.length == 0)
                return 0;
            if(heights.length == 1)
                return heights[0];
            int maxArea = 0;
            int maxLeftHeightIndex, maxRightHeightIndex;
            for (int i = 0; i < heights.length ; i++) {
                maxLeftHeightIndex = i;
                maxRightHeightIndex = i;

                for (int j = i-1; j >= 0; j--) {
                    if(heights[j] >= heights[i]){
                        maxLeftHeightIndex = j;
                    }else{break;}
                }
                for (int j = i+1; j < heights.length; j++) {
                    if(heights[j] >= heights[i]){
                        maxRightHeightIndex = j;
                    }else{break;}
                }
                int tmpArea = heights[i] * (maxRightHeightIndex - maxLeftHeightIndex + 1);
                System.out.println(tmpArea);
                if(tmpArea > maxArea)
                    maxArea = tmpArea;
            }
            return maxArea;
        }
    }
/*输入: [2,1,5,6,2,3]
输出: 10
* */
    public static void main(String[] args) {
        Solution solution = new A84_largest_rectangle_in_histogram().new Solution();
        int[] heights = new int[]{2,1,5,6,2,3};
        System.out.println(solution.largestRectangleArea(heights));
    }
}
