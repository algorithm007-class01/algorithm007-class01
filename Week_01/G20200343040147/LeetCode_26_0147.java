import java.util.Arrays;

public class LeetCode_26_0147 {

    /**
     * 1、原地修改——>双指针
     * 2、O(1)的额外空间——>不引入其他容器、
     * 3、给定的排序——>不用单独处理重复
     */

    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 2, 4, 4, 5, 7, 9, 10, 10, 11};

        System.out.println(new LeetCode_26_0147().removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));

    }

}