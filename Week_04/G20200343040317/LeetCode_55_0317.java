class Solution {
    // 输入示例： 2,3,1,1,4
    // 从后往前开始梳理，如果要到达这个点，至少的从那个点开始跳
    public boolean canJump(int[] nums) {
        // 入参校验
        if (nums.length == 0) {
            return false;
        }
        int endReachable = nums.length - 1;
        // i节点能否到达endReachable
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] + i >= endReachable) {
                endReachable = i;
            }
        }
        return endReachable == 0;
    }
}