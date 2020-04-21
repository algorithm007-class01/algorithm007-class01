package com.szp.leetcode.q1_50;

public class A45_jump_game_ii {
    class Solution {
        public int jump(int[] nums) {
            int len = nums.length;
            if(len == 1)
                return 0;
            if(len == 2)
                return 1;

            int[] dp = new int[len];
            dp[len - 1] = 0;
            for (int i = len - 2; i >= 0; i--) {
                int n = nums[i];
                int min = len;
                for (int j = 1; j <= n; j++) {
                    if (i + j > len - 1) {
                        break;
                    }
                    if (dp[i + j] < min)
                        min = dp[i + j];
                }
                dp[i] = min + 1;
            }
            return dp[0];
        }
    }

    public static void main(String[] args) {
        Solution solution = new A45_jump_game_ii().new Solution();
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(solution.jump(nums));

    }
}
