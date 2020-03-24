/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 *
 * https://leetcode-cn.com/problems/trapping-rain-water/description/
 *
 * algorithms
 * Hard (49.23%)
 * Likes:    947
 * Dislikes: 0
 * Total Accepted:    65.1K
 * Total Submissions: 131.4K
 * Testcase Example:  '[0,1,0,2,1,0,1,3,2,1,2,1]'
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 
 * 
 * 
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢
 * Marcos 贡献此图。
 * 
 * 示例:
 * 
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * 
 */

// @lc code=start
class Solution {
    public int trap(int[] heights) {
        int[] maxLeftHeights = new int[heights.length];
        for (int i = 1; i <= heights.length - 2; i++) {
            maxLeftHeights[i] = Math.max(maxLeftHeights[i - 1], heights[i - 1]);
        }

        int[] maxRightHeights = new int[heights.length];
        for (int i = heights.length - 2; i >= 1; i--) {
            maxRightHeights[i] = Math.max(maxRightHeights[i + 1], heights[i + 1]);
        }

        int sum = 0;
        for (int i = 1; i < heights.length - 1; i++) {
            int minBoundaryHeight = Math.min(maxLeftHeights[i], maxRightHeights[i]);
            if (minBoundaryHeight > heights[i]) {
                sum += (minBoundaryHeight - heights[i]);
            }
        }
        return sum;
    }

    /**
     * 从第二根柱子遍历到倒数第二根柱子，分别找出每根柱子的最高左柱和最高右柱。
     * 如果这两个柱子都高于当前柱子，那么当前柱子头上一定有水，
     * 其水量为最高左柱和最高右柱中较低的那个柱子与当前柱子的高度差。
     */
    public int trap1(int[] heights) {
        int sum = 0;
        for (int i = 1; i < heights.length - 1; i++) {
            int maxLeftHeight = 0;
            for (int j = 0; j < i; j++) {
                if (heights[j] > maxLeftHeight) {
                    maxLeftHeight = heights[j];
                }
            }

            int maxRightHeight = 0;
            for (int j = i + 1; j < heights.length; j++) {
                if (heights[j] > maxRightHeight) {
                    maxRightHeight = heights[j];
                }
            }

            int minBoundaryHeight = Math.min(maxLeftHeight, maxRightHeight);
            if (minBoundaryHeight > heights[i]) {
                sum += (minBoundaryHeight - heights[i]);
            }
        }
        return sum;
    }
}
// @lc code=end

