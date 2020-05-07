class Solution {
public:
    int reversePairs(vector<int>& nums) {
        if (nums.size() == 0) return 0;
        return mergeSort(nums, 0, nums.size() - 1);
    }
    int mergeSort (vector<int>& nums, int left, int right) {
        if (left >= right) return 0;
        int mid = left + ((right - left) >> 1);
        int count = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);
        int * temp = new int[right - left + 1];
        int i = left, t = left, k = 0;
        for (int j = mid + 1; j <= right; j++, k++) {
            while (i <= mid && nums[i] <= 2 * (long)nums[j]) i++;
            while (t <= mid && nums[t] < nums[j]) temp[k++] = nums[t++];
            temp[k] = nums[j];
            count += mid - i + 1;
        }
        while (t <= mid) temp[k++] = nums[t++];
        for (int p = 0; p < right - left + 1; p++) {
            nums[left + p] = temp[p];
        }
        return count;
    }
};