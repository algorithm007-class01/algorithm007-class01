/**
 * 寻找旋转数组中的最小值
 */
public int findMin(int[] nums) {

    if (nums.length == 1) {
        return nums[0];
    }

    int left = 0;
    int right = nums.length - 1;

    if(nums[left] < nums[right]) {
        return nums[left];
    }

    while (left <= right) {
        int mid = left + (right - left) / 2;

        if (nums[mid] > nums[mid + 1]) {
            return nums[mid + 1];
        }
        if (nums[mid - 1] > nums[mid]) {
            return nums[mid];
        }

        if(nums[left] < nums[mid]) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    return -1;
}