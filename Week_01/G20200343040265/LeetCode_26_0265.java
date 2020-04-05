class Solution {
    public int removeDuplicates(int[] nums) {
        if(null == nums || nums.length < 1) {
            return 0;
        }
        int curIndex = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i - 1]) {
                nums[curIndex] = nums[i];
            
                curIndex++;
            }
        }
        return curIndex;
    }
}
