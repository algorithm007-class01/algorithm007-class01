class Solution {
   public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        //  双指针
        // j 表示当前不重复数据的位置
        // i 表示扫描位置
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[j] != nums[i]) {
                nums[++j] = nums[i];
            }
        }
        return j + 1;
    }
}