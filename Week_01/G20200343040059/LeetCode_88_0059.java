/**
*   双指针从后往前遍历
*   2个数组分别从数组的最后值开始遍历，然后判断大小，并将较大值放到num1的最后，较大值对应的指针往前移动
*   
*   时间复杂度O(n)
**/
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 指针p1,p2
        // p1为nums1对应有值的位置
        int p1 = m - 1;
        // p2为nums2对应有值的位置
        int p2 = n - 1;
        // p为nums1的末尾
        int p = nums1.length - 1;

        // 循环条件：p1和p2的元素都没有遍历完
        while ((p1 >= 0) && (p2 >= 0)) {
            // 比较nums1[p1] 和 nums2[p2]的大小
            // 如果nums1[p1]的值小于nums2[p2]，则将nums2[p2]（较大的值）赋值到nums1的后面，然后指针p和p1往前移;
            // 如果nums1[p1]的值大于nums2[p2]，则将nums1[p1]（较大的值）复制到nums1的后面，然后指针p和p1往前移;
            nums1[p--] = nums1[p1] < nums2[p2] ? nums2[p2--] : nums1[p1--];
        }

        // 由于题目有一个条件假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素
        // 所以nums2中大的值已经加入nums1中，所以把剩下的小值全部驾到nums1中的前面部分
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }
}