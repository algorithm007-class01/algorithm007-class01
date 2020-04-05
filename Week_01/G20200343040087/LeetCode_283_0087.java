public class LeetCode_283_0087 {
    private void fixedCleanSolution(int[] nums) {
        for (int i = 0, j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i++] = tmp;
            }
        }
    }
}
