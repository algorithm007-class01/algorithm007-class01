public class LeetCode_283_0145 {
    /**
     * 移动 0
     * */
    public void moveZeros(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count += 1;
            }else {
                nums[i - count] = nums[i];
            }
        }
        for (int i = (nums.length - count); i < nums.length; i++) {
            nums[i] = 0;
        }
    }

}
