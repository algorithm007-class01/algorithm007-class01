class Solution {
    public void moveZeroes(int[] nums) {
            if (nums == null || nums.length == 0) {
                return;
            }

            int j = 0;
            //第一次遍历，将非0数字按顺序进行赋值
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    nums[j++] = nums[i];
                }
            }
            //第二次遍历，将0补齐
            for (int i = j; i < nums.length; i++) {
                nums[i] = 0;
            }
    }
}