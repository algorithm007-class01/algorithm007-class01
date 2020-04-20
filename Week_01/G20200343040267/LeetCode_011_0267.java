/**
 * 11. 盛最多水的容器
 *
 * https://leetcode-cn.com/problems/container-with-most-water
 */
class Solution {
    public int maxArea(int[] height) {
        int i = 0, maxArea = 0, j = height.length - 1;

        while(i < j){
            maxArea = height[i] < height[j] ?
                    Math.max(res, (j - i) * height[i++]):
                    Math.max(res, (j - i) * height[j--]);
        }

        return maxArea;
    }
}