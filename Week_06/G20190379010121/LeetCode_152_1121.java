class Solution {
    public int maxProduct(int[] nums) {
        int[] dpmax = new int[nums.length];
        int[] dpmin = new int[nums.length];
        dpmax[0] = nums[0];
        dpmin[0] = nums[0];
        int max = dpmax[0];
        int min = dpmin[0];
        for(int i = 1; i < nums.length; i ++){
            dpmax[i] = Math.max(nums[i],Math.max(nums[i] * dpmax[i-1],nums[i] * dpmin[i-1]));
            max = Math.max(dpmax[i],max);
            dpmin[i] = Math.min(nums[i],Math.min(nums[i] * dpmax[i-1],nums[i] * dpmin[i-1]));
            min = Math.min(dpmin[i],min);
        }
        return max;
    }
}