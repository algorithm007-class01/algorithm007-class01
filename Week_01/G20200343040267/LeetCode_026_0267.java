/**
 * 26. 删除排序数组中的重复项
 *
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null)
            return 0;

        if (nums.length < 2)
            return nums.length;

        int p = 0;
        int q = 1;
        while (q < nums.length) {
            if (nums[p] != nums[q]) {
                nums[++p] = nums[q];
            }

            q++;
        }

        return p + 1;
    }
}