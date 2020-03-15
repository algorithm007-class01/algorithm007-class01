
import java.util.Arrays;

/**
 * 合并两个有序数组
 * https://leetcode-cn.com/problems/merge-sorted-array/
 */
public class LeetCode_88_MergeSortedArray {

    /**
     * 先append到数组后面再对整个数组进行排序
     *
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i : nums2) {
            nums1[m] = i;
            m++;
        }
        Arrays.sort(nums1);
    }

}
