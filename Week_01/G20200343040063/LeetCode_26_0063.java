class Solution {
    
    // 1. 双指针法 关键：记录重复的数  移动数组元素
    // 

    public int removeDuplicates(int[] nums) {
        int i = 0;
        for(int j = 1; j < nums.length; j++){
            if(nums[i] != nums[j]){
                nums[++i] = nums[j];
            }
        }
        return i+1;
    }

}