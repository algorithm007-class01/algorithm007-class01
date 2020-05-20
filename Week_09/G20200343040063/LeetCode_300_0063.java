class Solution {

    // 1. 动态规划解法  
    // 定义状态 dp[i] 
    // 状态转移方程 dp[i] = max(dp[i],dp[j]+1)

    public int lengthOfLIS(int[] nums) {
        int res = 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        for(int i = 0 ; i < nums.length ; i++){
            for(int j = 0 ; j < i ; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            res = Math.max(dp[i],res);
        }
        return res;
    }
}