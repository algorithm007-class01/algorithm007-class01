

public int search(int[] nums, int target) {
    int start = 0;
    int end = nums.length - 1;

    int mid;
    while (start <= end) {
        mid = start + (end - start) / 2;

        if (nums[mid] == target) {
            return mid;
        }
        //前半部分有序
        if(nums[start] <= nums[mid]) {
            //二叉查找
            if(target >= nums[start] && target <= nums[mid]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        } else {
            if (target > nums[mid] && target <= nums[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
    }
    return -1;
}