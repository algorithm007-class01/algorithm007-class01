class Solution {
    public boolean canJump(int[] nums) {
        int reachable = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; --i) {
            if(nums[i] + i >= reachable) 
                reachable = i;
        }
        return reachable == 0;
    }
}