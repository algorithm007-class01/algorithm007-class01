class Solution {
public:
    int rob(vector<int>& nums) {
        int n = nums.size();
        if (n <= 1) return n == 0 ? 0 : nums[0];
        return max(robHelper(nums, 0, n-1), robHelper(nums, 1, n));
    }

    int robHelper(vector<int>& nums, int start, int end) {
        int curMax = 0, preMax = 0;
        for (int i = start; i < end; i++) {
            int temp = curMax;
            curMax = max(preMax + nums[i], curMax);
            preMax = temp;
        }
        return curMax;
    }
};
