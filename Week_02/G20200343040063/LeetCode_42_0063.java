/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {

    /** 暴力解法 */
    public int trap1(int[] height) {
        int sum = 0;
        for (int i = 1; i < height.length; i++) {
             // 找左边最高的柱子
             int maxLeft = 0;
             for (int j = i-1; j >= 0; j--) {
                 if(height[j] > maxLeft){
                    maxLeft = height[j];
                 }
             }
             // 找右边最高的柱子
             int maxRight = 0;
             for (int j = i+1; j < height.length; j++) {
                 if(height[j] > maxRight){
                    maxRight = height[j];
                 }
             }
             // 用最小边减去当前的柱子（前提：最小边大于当前柱子）
             int minHeight = Math.min(maxLeft, maxRight);
             if(minHeight > height[i]){
                sum += minHeight - height[i];
             }
        }
        return sum;
    }

    /**
     *  动态规划解法
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        int sum = 0;
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        for (int i = 1; i < maxLeft.length-1; i++) {
            maxLeft[i] = Math.max(maxLeft[i-1], height[i-1]);
        }
        for (int i = maxRight.length-2; i >=0 ; i--) {
            maxRight[i] = Math.max(maxRight[i+1], height[i+1]);
        }
        for (int i = 1; i < height.length; i++) {
            // 最矮的柱子减去当前柱子 （如果高于当前柱子）
            int minHeight = Math.min(maxLeft[i], maxRight[i]);
            sum += minHeight>height[i]?minHeight-height[i]:0;
        }
        return sum;
    }

    /**
     * 双指针法（动态规划的基础上优化空间复杂度）
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int sum = 0;
        int maxLeft = 0;
        int maxRight = 0;
        int left = 1;
        int right = height.length - 2;
        for (int i = 1; i < height.length -1; i++) {
             if(height[left-1]< height[right+1]){
                maxLeft = Math.max(maxLeft, height[left-1]);
                sum += maxLeft>height[left]?maxLeft-height[left]:0; 
                left++;
             } else{
                maxRight = Math.max(maxRight, height[right+1]);
                sum += maxRight>height[right]?maxRight-height[right]:0; 
                right--;
             }
        }
        return sum;
    }

}
// @lc code=end

