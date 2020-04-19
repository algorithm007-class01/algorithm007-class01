class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        int mid = 0;
        while (left < right) {
            mid = left + (right - left) / 2;
            // mid右侧是无序的，最小值应该在mid右侧
            if (nums[mid] > nums[right]) {
                // 修改区间为[mid + 1, right]
                left = mid + 1;
            } else {
                // mid右侧是有序的，但mid可能是最小值
                right = mid;
            }
        }
        // 最后输出的元素一定为最小的元素。
        return nums[left];
    }
}
