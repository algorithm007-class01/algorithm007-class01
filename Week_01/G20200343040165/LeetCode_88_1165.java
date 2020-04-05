class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums1.length < m + n || nums2 == null || nums2.length < n) {
            return;
        }

        int p1 = m - 1;
        int p2 = n - 1;
        
        int p = m + n - 1;
        while (p1 >= 0 && p2 >= 0) {
            nums1[p--] = nums1[p1] <= nums2[p2] ? nums2[p2--] : nums1[p1--];
        }

        if (p1 < 0) {
            while (p2 >= 0) {
                nums1[p--] = nums2[p2--];
            }
        }
    }
}