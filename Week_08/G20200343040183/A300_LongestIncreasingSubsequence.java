package com.szp.leetcode.q251_300;

public class A300_LongestIncreasingSubsequence {
/*
动态规划算法
 */
    public class Solution {
        public int lengthOfLIS(int[] nums) {
            if(nums == null || nums.length == 0)
                return 0;
            // 最直接的做法，双层循环
            int len = nums.length;
            int[] dp = new int[len];
            dp[0] = 1;
            int maxCount = 1;
            for(int i = 1; i < len; i++){
                int tmpMax = 0;//小于i的数组的中最长递增子序列的最大值
                for(int j  = 0; j < i; j++){
                    if(nums[i] > nums[j]){
                        tmpMax= Math.max(tmpMax, dp[j]);
                    }
                }
                dp[i] = tmpMax + 1;
                maxCount = Math.max(dp[i], maxCount);
            }

            return maxCount;
        }

        public int lengthOfLIS(int[] nums, int start, int max) {
            if(nums.length == 0)
                return 0;
            // 最直接的做法，双层循环
            int len = nums.length;
            int maxCount = 1;
            for(int i = 0; i < len; i++){
                int tmpCount = 1;
                int tmpNum = nums[i];;;;;
                for(int j  = i+1; j < len; j++){

                    if(nums[j] > tmpNum){
                        tmpCount += 1;
                        tmpNum = nums[j];
                    }
                }
                maxCount = tmpCount > maxCount ? tmpCount : maxCount;
            }

            return maxCount;
        }
    }
    public class Solution2 {
        public int lengthOfLIS(int[] nums) {
            return 0;
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        A300_LongestIncreasingSubsequence.Solution solution = new A300_LongestIncreasingSubsequence().new Solution();
        System.out.println("*****" + solution.lengthOfLIS(nums));
    }


}
