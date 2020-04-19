class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        int reachAble = nums[nums.length - 1];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= reachAble) {
                reachAble = i;
            }
        }
        return reachAble == 0;
    }
}