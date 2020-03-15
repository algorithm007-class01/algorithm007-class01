package G20200343040211;

public class LeetCode_189_0211 {
    public static void rotate(int[] nums, int k) {
        if(k < 0) return;
        int len = nums.length;
        int mod_k = k % len;
        for (int i = 0; i < mod_k; i++) {
            int temp = nums[len - 1];
            for (int j = len -1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }
    }
}
