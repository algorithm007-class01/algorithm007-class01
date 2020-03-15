class Solution {
    public void moveZeroes(int[] nums) {
        int noZeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[noZeroCount] = nums[i];
                noZeroCount++;
            }
        }
        while (noZeroCount < nums.length) {
            nums[noZeroCount] = 0;
            noZeroCount++;
        }
    }
}