class Solution {
    public int findMin(int[] nums) {
        if (nums==null || nums.length==0) return -1;
        int left = 0, right = nums.length-1;
        while (left < right) {
            int mid = left + (right-left)/2;
            if (nums[mid] > nums[right]) {
                left = mid +1;
            }else {
                right = mid;
            }
        }
        return nums[left] > nums[right] ? nums[right] : nums[left];
    }
}