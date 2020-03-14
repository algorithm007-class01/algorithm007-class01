/**
*
* 88. 合并两个有序数组 <p>
* https://leetcode-cn.com/problems/merge-sorted-array/
*/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    	//新数组
        int[] newNums = new int[m + n];

        int index1 = 0, index2 = 0, count = 0;

        while (index1<m && index2<n) {
            newNums[count++]=nums1[index1]<nums2[index2]?nums1[index1++]:nums2[index2++];
        }

        while (index1<m && index2<n) {
            if (nums1[index1] < nums2[index2]) {
                newNums[count++] = nums1[index1++];
            } else {
                newNums[count++] = nums2[index2++];
            }
        }
        
        if(index1<m){
            System.arraycopy(nums1,index1,newNums,index1+index2,m+n-index1-index2);
        }

        if(index2<n){
            System.arraycopy(nums2,index2,newNums,index1+index2,m+n-index1-index2);
        }

        System.arraycopy(newNums,0,nums1,0,m+n);
    }
}