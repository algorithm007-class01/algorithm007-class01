package com.szp.leetcode.q51_100;

public class A55_jump_game {
    class Solution {
        public boolean canJump(int[] nums) {
            int len = nums.length;
            if(len == 1)
                return true;
            if(len == 2)
                return nums[0] != 0;

            int[] dp = new int[len];
            dp[len - 1] = 0;
            for (int i = len - 2; i >= 0; i--) {
                int n = nums[i];
                int min = len;
                int notAvaliable = 0;
                if(n == 0){
                    dp[i] = -1;
                }else {
                    for (int j = 1; j <= n; j++) {
                        if (i + j > len - 1) {
                            break;
                        }
                        if(dp[i+j] == -1){
                            notAvaliable++;
                        }else {
                            if (dp[i + j] < min)
                                min = dp[i + j];
                        }
                    }
                }
                if(notAvaliable == n)
                    dp[i] = -1;
                else
                    dp[i] = min + 1;
            }
            return dp[0] != -1;
        }
//        解题思路：
//
//        如果某一个作为 起跳点 的格子可以跳跃的距离是 3，那么表示后面 3 个格子都可以作为 起跳点。
//        可以对每一个能作为 起跳点 的格子都尝试跳一次，把 能跳到最远的距离 不断更新。
//        如果可以一直跳到最后，就成功了。
        boolean canJump2(int[] nums)
        {
            int k = 0;
            for (int i = 0; k < nums.length - 1; i++)
            {
                if (i > k) return false;
                k = Math.max(k, i + nums[i]);
            }
            return true;
        }


    }
//    示例 1:
//
//    输入: [2,3,1,1,4]
//    输出: true
//    解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
//    示例 2:
//
//    输入: [3,2,1,0,4]
//    输出: false
//    解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
    public static void main(String[] args) {
        Solution solution = new A55_jump_game().new Solution();
        int[] nums = new int[]{2,3,1,1,4};
        int[] nums2 = new int[]{3,2,1,0,4};
        System.out.println(solution.canJump(nums));
        System.out.println(solution.canJump(nums2));
    }
}
