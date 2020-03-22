//88. 合并两个有序数组

//从m+n开始从后往前归并排序

class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {

        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;
        while(p1 >= 0 && p2 >= 0)
        {
            nums1[p--] = (nums1[p1] > nums2[p2]) ? nums1[p1--] : nums2[p2--];
        }
        while(p2 >= 0)
        {
            nums1[p--] = nums2[p2--];
        }
        
    }
};
//时间复杂度 O(n) 空间复杂度 O(1)