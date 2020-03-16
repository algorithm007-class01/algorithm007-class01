class Solution {
    public void moveZeroes(int[] nums) {
        int temp;
        int len = nums.length;
        for (int i = 0, j = 0; i < len; i++) {
            if (nums[i] != 0) {
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }
}