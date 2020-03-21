public class LeetCode_88_0201 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 新建一个数组，作为最后的返回结果
        int[] resArr = new int[m + n];
        int np1 = 0, np2 = 0, idx = 0;
        // nums1和2，各一个指针，选出小的放入结果数组resArr中
        while (np2 < n && np1 < m) {
            if (nums2[np2] < nums1[np1]) {
                resArr[idx++] = nums2[np2++];
            } else {
                resArr[idx++] = nums1[np1++];
            }
        }
        // 如果nums1的有效元素先遍历完，结果数组后续的元素，用nums2的填上
        if (np1 == m) {
            while (np2 < n) resArr[idx++] = nums2[np2++];
        }
        // 如果nums2的有效元素先遍历完，结果数组后续的元素，用nums1的填上
        if (np2 == n) {
            while (np1 < m) resArr[idx++] = nums1[np1++];
        }
        // 因为最后的结果是nums1，所以，将结果数组resArr拷贝到nums1
        while (--idx >= 0) {
            nums1[idx] = resArr[idx];
        }
    }
}
