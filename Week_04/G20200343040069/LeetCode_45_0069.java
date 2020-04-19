class Solution {
    public int jump(int[] nums) {
        if(nums.length == 1) return 0;
        int postion = nums.length -1;
        int step = 0;

        while(postion != 0){
            for(int i=0; i< postion;i++){
                if( i + nums[i] >= postion){
                    postion = i;
                    step++;
                    break;
                }
            }
        }
        return step;
    }
}