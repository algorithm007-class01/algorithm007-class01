public class LeetCode_55_0147 {

    public boolean canJump(int[] nums) {
        //能去到的地方
        int canGo = 0;
        for (int i = 0; i < nums.length; i++) {
            //走不了那么远
            if (i > canGo) {
                return false;
            }
            canGo = Math.max(canGo, nums[i] + i);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(new LeetCode_55_0147().canJump(nums));
    }
}
