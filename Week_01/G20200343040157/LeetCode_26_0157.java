class Solution {
    public int removeDuplicates(int[] nums) {
        // 边界条件第一次没考虑好
        if(nums == null || nums.length == 0){
            return 0;
        }
        int avaiableIndex = 0;
        int cursor = 1;
        for (;cursor < nums.length; cursor ++) {
            if (nums[cursor] != nums[avaiableIndex]){
                avaiableIndex++;
                nums[avaiableIndex] = nums[cursor];
            }
        }
        return avaiableIndex + 1;
    }
}