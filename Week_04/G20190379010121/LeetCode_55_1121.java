class Solution {
    //正向解题
    public boolean canJump(int[] nums) {
        int max = 0;
        for(int i = 0;i < nums.length;i ++){
            if(i > max){
                return false;
            }
            max = Math.max(nums[i]+i,max);
        }
        return true;
    }
    //逆向倒推
    public boolean canJump(int[] nums) {
        int last = nums.length-1;
        for(int i = last; i>=0;i --){
            if(nums[i] + i >= last){
                last = i;
            }
        }
        return last == 0;
    }



}