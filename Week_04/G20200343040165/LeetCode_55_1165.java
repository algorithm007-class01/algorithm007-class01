class Solution {
    public boolean canJump(int[] nums) {
        // int lastPos = nums.length - 1;
        // for (int i = nums.length - 1; i >= 0; i--) {
        //     if (nums[i] + i >= lastPos) {
        //         lastPos = i;
        //     }
        // }
        // return lastPos == 0;

        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > k) return falses;
            if (i + nums[i] > k) {
                k = i + nums[i];
            }
        }
        return true;
    }
}