class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m == 0){
            nums1[0] = nums2[0];
        }
        int pm = m-1;
        int pn = n-1;
        for(int i = m + n -1; pm >= 0 && pn >= 0;i --){
            if(nums1[pm] >= nums2[pn]){
                nums1[i] = nums1[pm--];
            }else{
                nums1[i] = nums2[pn--];
            }
        }
        if(pm < 0){
            for(int i = 0;i <= pn; i ++){
                nums1[i] = nums2[i];
            }
        }
    }
}