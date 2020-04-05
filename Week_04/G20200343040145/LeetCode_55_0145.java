public class LeetCode_55_0145 {

    /**
     *  反向推，从倒数第一个位置开始，看能不能走到倒数第二个位置，
     *  一直向初始位置前进，如果 tail > 0 说明无法从初始位置跳到最后位置
     * */
    public static boolean canJump(int[] nums) {
        if (nums == null) {
            return false;
        }
        int tail = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if ((nums[i] + i) >= tail) {
                tail = i;
            }
        }
        return tail == 0;
    }
}
