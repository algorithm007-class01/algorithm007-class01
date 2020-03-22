/**
 * 26. 删除排序数组中的重复项
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 */
public class l26removeDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int i = new Solution().removeDuplicates(nums);
        System.out.println(i);
    }

    static class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            int i = 0;
            int j = 1;
            while (j < nums.length) {
                if (nums[i] != nums[j]) {
                    nums[i + 1] = nums[j];
                    i++;
                }
                j++;
            }
            return i + 1;
        }
    }
}
