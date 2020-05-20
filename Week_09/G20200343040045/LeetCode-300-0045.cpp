#include <algorithm>
#include <iostream>
#include <vector>
using namespace std;
/**
 * 最长上升子序列
 * dp求解：递推公式为dp[i]=max(dp[i],dp[j+1])
*/
class Solution {
   public:
    int lengthOfLIS(vector<int>& nums) {
        int n = (int)nums.size();
        if (n == 0) return 0;
        vector<int> dp(n, 0);
        for (int i = 0; i < n; ++i) {
            dp[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) {
                    dp[i] = max(dp[i], dp[j] + 1);
                }
            }
        }
        // 返回最大元素
        return *max_element(dp.begin(), dp.end());
    }
};
