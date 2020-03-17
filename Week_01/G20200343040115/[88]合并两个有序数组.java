//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 num1 成为一个有序数组。 
//
// 
//
// 说明: 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
//
// 
//
// 示例: 
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
// Related Topics 数组 双指针


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     *
     * the first one
     */
        public void merge(int A[], int m, int B[], int n) {
            int i = m - 1, j = n - 1, k = m + n - 1;
            while(i >= 0 && j >= 0) {
                A[k--] = A[i] > B[j] ? A[i--] : B[j--];
            }
            while(j >= 0) {
                A[k--] = B[j--];
            }
        }

//runtime:0 ms
//memory:38.5 MB


    /**
     * the second one,is more clean
     *
     */
        public void merge(int[] A, int m, int[] B, int n) {

            while(n>0) A[m+n-1] = (m==0||B[n-1] > A[m-1]) ? B[--n] : A[--m];
        }

//runtime:0 ms
//memory:38.3 MB


}
//leetcode submit region end(Prohibit modification and deletion)
