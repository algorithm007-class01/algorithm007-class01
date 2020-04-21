class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    private int rob(int[] nums, int begin, int end) {
        if (begin == end) {
            return nums[begin];
        }
        final int[] dp = new int[2];
        //  0 不打
        //  1 打劫
        while (begin <= end) {
            int tmp = dp[0];
            dp[0] = Math.max(dp[0], dp[1]);
            dp[1] = Math.max(tmp + nums[begin], dp[1]);
            begin++;
        }
        return Math.max(dp[0], dp[1]);
    }
}