class Solution {
    public int lengthOfLIS(int[] nums) {
        // dp[i]包含nums[i]且最后一位是nums[i]的最长升序的长度
        if (nums.length == 0) {
            return 0;
        }
        final int[] dp = new int[nums.length];
        dp[0] = 1;
        Arrays.fill(dp,1);
        int res = dp[0];
        for (int i = 1; i < nums.length; i++) {
            // 如果nums[i]>nums[i-1]  -->  dp[i] = dp[i-1]+1
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}