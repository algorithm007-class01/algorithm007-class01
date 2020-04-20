public class LeetCode33 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = left + (right - left) / 2;

        while (left <= right) {
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[left] <= nums[mid]) {
                // 左边升序
                if (target >= nums[left] && target <= nums[mid]) {
                    // 目标在左边范围
                    right = mid - 1;
                } else {
                    // 目标在右边范围
                    left = mid + 1;
                }
            } else {
                // 右边升序
                if (target >= nums[mid] && target <= nums[right]) {
                    // 目标在右边范围
                    left = mid + 1;
                } else {
                    // 目标在左边范围
                    right = mid - 1;
                }
            }
            mid = left + (right - left) / 2;
        }
        return -1;
    }
}
