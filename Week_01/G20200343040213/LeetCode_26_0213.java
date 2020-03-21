class Solution {
    public int removeDuplicates(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }

        int index = 1;
        int lastDiff = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (lastDiff != nums[i]) {
                lastDiff = nums[i];
                nums[index] = lastDiff;
                index ++;
            }
        }
        return index;
    }
}