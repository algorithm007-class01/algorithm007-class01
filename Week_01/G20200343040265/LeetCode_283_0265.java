class Solution {
    public void moveZeroes(int[] nums) {
        //从第一位开始扫描
        //定义0计数器count
        //遇到0，count++
        //扫描下一位，非0，左移i-count位，即置换第一位0和i的位置
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0) {
                count++;
            } else if(count != 0) {
                nums[i - count] = nums[i];
                nums[i] = 0;
            }
        }
    }
}
