// time O(n) space O(1)
class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int n = height.length;
        int i = 0, j = n - 1, totalWater = 0, bucket = 0;

        while (i < j) {
            // 矮的当砖头
            int block = Math.min(height[i], height[j]);
            // 砖头和桶边，哪个高哪个当新的桶边
            bucket = Math.max(bucket, block);
            // 存水量就是桶边减去矮的那边的高度
            totalWater += height[i] < height[j] ? bucket - height[i++] : bucket - height[j--];
        }

        return totalWater;
    }
}