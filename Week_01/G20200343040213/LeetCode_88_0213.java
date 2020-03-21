class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int nums1Index = m - 1;
        int nums2Index = n - 1;
        int i = m + n - 1;
        for (; i >= 0 && nums1Index >= 0 && nums2Index >= 0; i --) {
            if (nums1[nums1Index] < nums2[nums2Index]) {
                nums1[i] = nums2[nums2Index --];
            } else {
                nums1[i] = nums1[nums1Index --];
            }
        }

        for (; nums2Index >= 0; i --) {
            nums1[i] = nums2[nums2Index --];
        }
    }
}