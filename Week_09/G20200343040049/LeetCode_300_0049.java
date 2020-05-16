// dp + binary search
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        // tail[i]存储长度为i+1的子序列的最后一个元素值
        int[] tail = new int[n];
        int idx = 0;
        
        for (int i = 0; i < nums.length; ++i) {
            int left = 0;
            int right = idx;

            while(left < right) {
                int mid = (left + right) >> 1;
                if (tail[mid] < nums[i])
                    left = mid + 1;
                else right = mid;
            }
            tail[left] = nums[i];
            if (left == idx) idx++;
        }
        return idx;
    }
}
// dp
// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         int n = nums.length;
//         if (n == 0) return 0;

//         int[] dp = new int[n];
//         int len = 0;
//         for (int i = 0; i < n; ++i) {
//             dp[i] = 1;
//             for (int j = 0; j < i; ++j) {
//                 if (nums[i] > nums[j])
//                     dp[i] = Math.max(dp[i], dp[j] + 1);
//             }
//             len = Math.max(len, dp[i]);
//         }
//         return len;
//     }
// }