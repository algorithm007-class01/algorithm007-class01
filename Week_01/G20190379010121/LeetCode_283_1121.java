class Solution {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0){
            return ;
        }
        int non = 0;
        for(int i = 0;i < nums.length; i ++){
            if(nums[i] != 0){
                swap(nums,i,non ++);
            }
        }
    }
    private void swap(int[] nums,int from,int to){
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }
}