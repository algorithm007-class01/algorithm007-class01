class Solution {
    public void moveZeroes(int[] nums) {
        // 记录非 0 元素移动位置
        int index = 0;

        // 数组长度
        int length = nums.length;

        for (int i = 0; i < length; i ++) {
            if (0 != nums[i]) {
                nums[index ++] = nums[i];
            }
        }

        for (;index < length; index ++) {
            nums[index] = 0;
        }
    }
}