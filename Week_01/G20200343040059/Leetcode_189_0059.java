/**
*   数组旋转
*   使用官方方法4
*   1）整体反转
*   2）前K个反转
*   3）后len-k个反转
*   时间复杂度O(n)，空间复杂度O(1)
*
*
**/
class Solution {
    public void rotate(int[] nums, int k) {

        // 取余反转元素的个数，不直接使用k的原因是可能出现k大于len的情况
        k = k%nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length - 1);
    }

    /**
     * 数组反转
     *
     * @param nums  数组
     * @param start 开始反转位置
     * @param end   结束反转位置
     */
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            end--;
            start++;
        }
    }
}