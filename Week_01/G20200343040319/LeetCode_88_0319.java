class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = nums1.length-1;
        if (m==0) {
            for (int i=0;i<n;++i){
                nums1[i] = nums2[i];
            }
            return;
        }
        if (n==0) return;
        n--;m--;
        while (n>=0 && m>=0){
            if (nums1[m] <= nums2[n]){
                nums1[p1--] = nums2[n--];
            }
            else{
                nums1[p1--] = nums1[m--];
            }
        }
        if (n>=0){
            for(int i =0;i<=n;++i) nums1[i] = nums2[i];
        }
    }
}