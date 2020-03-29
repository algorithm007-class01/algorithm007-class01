class Solution {
    public void rotate(int[] nums, int k) {
          int numsLen = nums.length;
          int[] newA = new int[numsLen];
        for(int i=0; i<numsLen; i++){
            newA[(i+k)%numsLen] = nums[i];
        }
        for(int i=0; i<numsLen; i++){
            nums[i] = newA[i];
        }
    }
}