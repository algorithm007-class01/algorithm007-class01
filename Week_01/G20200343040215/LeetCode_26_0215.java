package Week_01;

public class LeetCode_26_0215 {
    /**
     * 双指针法
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if(nums.length==0){return 0;}
        int index = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[index]!=nums[i]){//前比后大
                index++;
                nums[index]=nums[i];
            }
        }
        return index+1;
    }
}
