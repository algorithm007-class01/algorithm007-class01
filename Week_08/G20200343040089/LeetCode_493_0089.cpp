//	Use the idea of merge sort calculation
class Solution {
public:
    int reversePairs(vector<int>& nums) {
        if (nums.size() == 0) return 0;
        return mergerSort(nums, 0, nums.size() - 1);
    }
private:
    int mergerSort(vector<int>& nums, int left, int right) {
        if (left >= right) return 0;
        int mid = left + ((right - left) >> 1);
        int count = mergerSort(nums, left, mid) + mergerSort(nums, mid + 1, right);
        
        int n = right - left + 1;
        int cache[n];
        int i = left, t = left, c = 0;
        
        for (int j = mid + 1; j <= right; ++j, ++c) {
            while (i <= mid && nums[i] <= 2 * (long)nums[j]) i++;
            while (t <= mid && nums[t] < nums[j]) cache[c++] = nums[t++];
            cache[c] = nums[j];
            count += mid - i + 1;
        }
        while (t <= mid) cache[c++] = nums[t++];

        for (int i = 0; i < n; ++i) {
            nums[left + i] = cache[i];
        }
        return count;
    }
};