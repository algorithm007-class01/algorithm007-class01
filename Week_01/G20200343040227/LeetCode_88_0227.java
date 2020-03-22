
import java.util.Arrays;

/**
 * 88. 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 num1 成为一个有序数组。
 * <p>
 * <p>
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 *
 * https://leetcode-cn.com/problems/merge-sorted-array/
 */
public class LeetCode_88_0227 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //method1
        method2(nums1, m, nums2, n);
    }

    //Java自带包，个人人为不算解法

    /**
     * [一.]System.arraycopy使用的基本定义]
     * public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
     * src:源数组;
     * srcPos:源数组要复制的起始位置;
     * dest:目的数组;
     * destPos:目的数组放置的起始位置;
     * length:复制的长度.
     * 注意：src 和 dest都必须是同类型或者可以进行转换类型的数组．
     *
     * @param m
     * @param nums2
     * @param n
     */
    public void method1(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums2, m, n);
        Arrays.sort(nums1);
    }

    /**
     * 个人人为不算好的解法,借助额外空间实现，
     * 题目的初衷其实是不需要额外空间解决的，自己未想到。
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void method2(int[] nums1, int m, int[] nums2, int n) {
        int[] num1_m = new int[m];
        System.arraycopy(nums1, 0, num1_m, 0, m);
        //nums1的指针
        int p1 = 0;
        //nums2的指针
        int p2 = 0;
        //返回结果的指针
        int rs_p = 0;
        //和链表合并解法类似
        while (p1 < m && p2 < n) nums1[rs_p++] = num1_m[p1] < nums2[p2] ? num1_m[p1++] : nums2[p2++];
        while (p1 < m) nums1[rs_p++] = num1_m[p1++];
        while (p2 < n) nums1[rs_p++] = nums2[p2++];
    }

    /**
     * 未想到此解法，很精妙。从后面即可以不使用额外空间
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void method3(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        //从nums1的后面开始
        int rs_p = m + n - 1;
        while (p1 >= 0 && p2 >= 0) nums1[rs_p--] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
        //剩下的只需要考虑是nums2的情况
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 6, 7, 8};
        new LeetCode_88_0227().merge(nums1, 3, new int[]{1, 8}, 1);
        for (int r : nums1) {
            System.out.println(r);
        }
    }
}
