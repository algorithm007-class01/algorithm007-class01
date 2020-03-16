import java.util.Arrays;

public class LeetCode_283_0147 {


    /**
     * 1、双指针
     */
    public void moveZeroes(int[] nums) {

        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                nums[i++] = nums[j];
            }
        }

        for (int j = nums.length - 1; j > i - 1; j--) {
            nums[j] = 0;
        }

    }

    /**
     * 2、遇到0，交换到最后
     */
    public void moveZeroes2(int[] nums) {

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == 0) {
                    int tmp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = tmp;
                }
            }
        }

    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 9, 0, 1, 0, 3, 12};

        new LeetCode_283_0147().moveZeroes2(nums);

        System.out.println(Arrays.toString(nums));
    }
}
