public class LeetCode_33_0147 {

    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                return middle;
            }
            if (nums[middle] >= nums[left]) {
                if (nums[left] <= target && target <= nums[middle]) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            } else {
                if (nums[middle] <= target && target <= nums[right]) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {5, 1, 3};
        int target = 3;

        System.out.println(new LeetCode_33_0147().search(nums, target));
    }
}
