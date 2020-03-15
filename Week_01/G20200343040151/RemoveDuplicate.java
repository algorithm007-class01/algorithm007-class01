public class RemoveDuplicate {

    public int removeDuplicates(int[] nums) {
        int i =0;
        for (int index=1;index < nums.length;index++) {
            if(nums[i]!=nums[index]){
                i ++;
                nums[i] = nums[index];
            }
        }
        return i+1;
    }
}
