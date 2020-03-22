public class LeetCode_26_0145 {
    public int removeDuplicates(int[] nums) {
        int left =0;
        for (int right = 0; right < nums.length; right++) {
            // 双指针
            if (nums[left] != nums[right]) {
                left += 1;
                nums[left] = nums[right];
            }
        }
        return left + 1;
    }
}
