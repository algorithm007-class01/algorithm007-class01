package app;
public class LeetCode_26_0333{
    public int removeDuplicates(int[] nums) {
        if(null==nums||nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return 1;
        }
        int i=0;
        for(int j=1;j<nums.length;j++){
            if(nums[i]!=nums[j]){
                ++i;
                if(i!=j){
                    nums[i]=nums[j];
                }
                
            }
        }
        return i+1;
    }
}