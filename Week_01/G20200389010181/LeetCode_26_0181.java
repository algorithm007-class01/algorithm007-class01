package com.bai.leetcode.editor.en;

/**
 * @author Bai
 */
public class LeetCode_26_0181 {

    /**
     * 26. 删除排序数组中的重复项
     * <p>
     * 时间复杂度 O(n)，空间 O(1)
     * 思路:
     * 因为是有序数组，所以值的大小关系 很容易和数组索引一一对应
     * 所以将第 n 大的值直接赋值给索引 n 即可
     * </p>
     * <p>
     * 最佳答案是双指针，运行时间和这个一样，双指针复杂度 <= n, 这个复杂度 = n
     * </p>
     */
    public int removeDuplicates(int[] nums) {
        int realSort = 0;

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int last = nums[i - 1];
            if (curr != last) {
                realSort++;
            }
            nums[realSort] = curr;
        }
        return realSort + 1;
    }
}
