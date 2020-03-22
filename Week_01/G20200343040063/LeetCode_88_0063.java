class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = n-1;
        int k = m+n -1;
        for( ; i >= 0 && j >= 0  ;){
            nums1[k--] = nums1[i] > nums2[j] ?nums1[i--]:nums2[j--];
        }
        System.arraycopy(nums2,0,nums1,0,j+1);
    }
}