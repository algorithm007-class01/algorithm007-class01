
//88. 合并两个有序数组
//    给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 num1 成为一个有序数组。
//    说明:
//        初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
//        你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
//
//    示例:
//        输入:
//        nums1 = [1,2,3,0,0,0], m = 3
//        nums2 = [2,5,6],       n = 3
//
//        输出: [1,2,2,3,5,6]
// https://leetcode-cn.com/problems/merge-sorted-array/

// 实现思路3种：
// 思路1：合并后排序，直接将num2中数据添加到num1中，然后将num1排序，即可
// 时间复杂度O((n+m)log(n+m)),空间复杂度O(1),

// 思路2： 双指针 / 从前往后
// 开辟一个新的长度为m的数组temp_num,将num1进行复制,
// 同时遍历temp_num,num2,选择最小的一个，每次选择最小一个，放入新数组num1中
// 时间复杂度O(m+n),空间复杂度O(m),

// 思路3： 双指针 /  从后往前
// 思路2已经获取了最优时间复杂度，如果不开辟新空间，如何转移数据呢？
// 同时遍历num1,num2,选择最小的一个，每次选择最小一个，放入新数组num1中最后已给元素上，
// 时间复杂度O(m+n),空间复杂度O(1),

class Solution {
    // 思路3： 双指针 /  从后往前
    // 思路2已经获取了最优时间复杂度，如果不开辟新空间，如何转移数据呢？
    // 同时遍历num1,num2,选择最小的一个，每次选择最小一个，放入新数组num1中最后已给元素上，
    // 时间复杂度O(m+n),空间复杂度O(1),
    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1,
                j=n-1,
                k=m+n-1; // 指向nums数组最末端
        while (i>=0 && j>=0){
            if(nums1[i]<=nums2[j]){
                nums1[k--] = nums2[j];
                j--;
            }else {
                nums1[k--] = nums1[i];
                i--;
            }
        }
        // 上述遍历后，有可能存在nums1全部比nums2大，此时，nums1全部移动完成，但nums2数据并未移动到nums1中
        if(i == -1){
            for (int v = 0; v <= k; v++) {
                nums1[v] = nums2[v];
            }
        }
    }

    // 思路2： 双指针 / 从前往后
    // 开辟一个新的长度为m的数组temp_num,将num1进行复制,
    // 同时遍历temp_num,num2,选择最小的一个，每次选择最小一个，放入新数组num1中
    // 时间复杂度O(m+n),空间复杂度O(m),
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        // 将nums2中数组转移到nums1中
        int[] tmp_num = new int[m];
        for (int i = 0; i < m; i++) {
            tmp_num[i] = nums1[i];
        }

        int i=0,j=0,k=0;
        while (i<m && j<n){
            if(tmp_num[i]<nums2[j]){
                nums1[k++] = tmp_num[i];
                i++;
            }else if(tmp_num[i] == nums2[j]){
                nums1[k++] = tmp_num[i];
                i++;
                nums1[k++] = nums2[j];
                j++;
            }else {
                nums1[k++] = nums2[j];
                j++;
            }
        }
        if (i < m)
            System.arraycopy(tmp_num, i, nums1, i + j, m + n - i -j );
        if (j < n)
            System.arraycopy(nums2, j, nums1, i + j, m + n - i -j );

    }


    // 思路1：合并后排序，直接将num2中数据添加到num1中，然后将num1排序，即可
    // 时间复杂度O((n+m)log(n+m)),空间复杂度O(1),
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 将nums2中数组转移到nums1中
        for (int i = 0; i < n; i++) {
            nums1[m+i] = nums2[i];
        }
        Arrays.sort(nums1);
    }

}