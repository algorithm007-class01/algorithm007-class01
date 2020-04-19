class Solution {
    public int jump(int[] nums) {
        int step = 0;
        int position = nums.length - 1;
        while(position != 0) {
            for (int i = 0; i < position; ++i) {
                if(nums[i] + i >= position) {
                    step++;
                    position = i;
                }
            }
        }
        return step;
    }
}