class Solution {
    // 状态定义
    // dp[i] 第i家获得的最大收益，
    // 这里有一个问题，这个收益是包含第i家的了,还是不包含呢？
    // 基于上面的问题，我们的dp状态应该是2维的，在上面的基础上增加一维，0 表示不偷，1 表示偷
    // dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1])
    // dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]+nums[i])
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        final int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + nums[i]);
        }
        return Math.max(dp[len - 1][0], dp[len - 1][1]);
    }
}