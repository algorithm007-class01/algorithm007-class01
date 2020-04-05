/**
 * 189. 旋转数组
 *
 * https://leetcode-cn.com/problems/rotate-array/
 */
public class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        // 反转所有数字
        reverse(nums, 0, nums.length - 1);
        // 反转前 k 个数字
        reverse(nums, 0, k - 1);
        // 反转后 n-k 个数字后
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}