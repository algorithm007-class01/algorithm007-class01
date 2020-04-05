class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        if (len == 0 || nums == null) {
            return ;
        }
        k = k % len;
        if (k == 0) {
            return ;
        }
        swap(nums, 0, len-1);
        swap(nums, 0, k-1);
        swap(nums, k, len-1);
    }

    public void swap(int[] nums, int start, int end){
        int temp;
        while (start < end) {
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}