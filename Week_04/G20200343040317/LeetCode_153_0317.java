class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1, mid = 0;
        // 下面这个点不能使用left <= right
        while (left < right) {
            mid = left + (right - left) / 2;
//            if (nums[mid] < nums[left]) {
//                // 左边旋转
//                right = mid;
//            } else if (nums[mid] > nums[right]) {
//                // 右边旋转
//                left = mid;
//            } else {
//                // 没有选择
//                return nums[left];
//            }

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // 下面这个点不能使用right = mid+1 ，这样就漏掉一个数据了
                right = mid;
            }
        }
        return nums[left];
    }
}