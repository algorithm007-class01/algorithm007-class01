package myself;

public class LeetCode_153_0201 {
    public int findMin(int[] nums) {
        if (nums.length == 0) return 0;

        int left = 0, right = nums.length - 1;
        while (left < right) {
            int pivot = (left + right) / 2;
            if (pivot != 0 && nums[pivot - 1] > nums[pivot])
                return nums[pivot];
            if (nums[pivot] < nums[right])
                right = pivot - 1;
            else {
                left = pivot + 1;
            }
        }
        return nums[left];
    }
}
