class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1Copy = new int[m];
        System.arraycopy(nums1, 0, nums1Copy, 0, m);

        int p = 0;
        int p1 = 0;
        int p2 = 0;

        while (p1 < m && p2 <n) {
            if (nums1Copy[p1] < nums2[p2]) {
                nums1[p] = nums1Copy[p1];
                p1++;
            } else {
                nums1[p] = nums2[p2];
                p2++;
            }
            p++;
        }

        int totalLength = m + n;
        int currentIndex = p1 + p2;
        int remainingLength = totalLength - currentIndex;
        if (p1 < m) {
            System.arraycopy(nums1Copy, p1, nums1, currentIndex, remainingLength);
        }

        if (p2 < n) {
            System.arraycopy(nums2, p2, nums1, currentIndex, remainingLength);
        }
    }
}