import java.util.Arrays;

public class LeetCode_189_0147 {

    /***
     * 1、拿出最后一个数
     * 2、所有数据向前移动一位
     * 3、补全第一位
     * 4、重复K次
     *
     */
    public void rotate(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int tmp = nums[nums.length - 1];
            System.arraycopy(nums, 0, nums, 1, nums.length - 1);
            nums[0] = tmp;
        }
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5};

        int k = 6;

        new LeetCode_189_0147().rotate(nums, k);

        System.out.println(Arrays.toString(nums));
    }

}


