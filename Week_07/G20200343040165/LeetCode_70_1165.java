class Solution {
    public int climbStairs(int n) {
        //解法一：动态规划，数组保存所有的值，时间复杂度O(N)，空间复杂度O(N)
        // if (n == 1) {
        //     return 1;
        // }

        // int[] dp = new int[n + 1];
        // dp[1] = 1;
        // dp[2] = 2;
        // for (int i = 3; i <= n; i++) {
        //     dp[i] = dp[i - 1] + dp[i - 2];
        // }
        // return dp[n];

        //解法二：斐波那契数列，时间复杂度O(N)，空间复杂度O(1)
        if (n == 1) {
            return 1;
        }

        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int result = first + second;
            first = second;
            second = result;
        }
        return second;
    }
}