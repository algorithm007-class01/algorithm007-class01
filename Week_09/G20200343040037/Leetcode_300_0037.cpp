class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        // 找到重复子结构
        // 当前i最长递增长度和之前j[0..i]最长递增长度+1.两者取最大值，谁大就

        // 定义状态数组
        //dp[i],表示以nums[i]结尾的最长递增长度。 i = nums[i], dp[i]是最长长度.
        // 初始值1， 目标值max(dp)
        // 定义状态方程
        //dp[i] = max(dp[i], dp[j] + 1).
        int size = nums.size();
        if(nums.empty()) {
            return 0;
        }
        vector<int> dp(size + 1, 1);
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    dp[i] = max(dp[i], dp[j] + 1);
                }
            }
        }

        int result = 0;
        for(int i = 0; i < size;i++) {
            result = max(result, dp[i]);
        }
        return result;

    }
};
