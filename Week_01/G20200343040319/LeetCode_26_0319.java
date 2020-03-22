class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        //corner  case
        if (len==0) return 0;

        int prev=nums[0];
        int j = 1;
        int ret = len;
        for (int i = 1; i < len; i++) {
            if (nums[i]!=prev){
               prev = nums[i];
               nums[j++] = nums[i];
            }
            else{
                ret--;
            }
        }
        
        return ret;
    }
}