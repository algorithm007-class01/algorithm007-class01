//给定一个无序的整数数组，找到其中最长上升子序列的长度。 
//
// 示例: 
//
// 输入: [10,9,2,5,3,7,101,18]
//输出: 4 
//解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。 
//
// 说明: 
//
// 
// 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。 
// 你算法的时间复杂度应该为 O(n2) 。 
// 
//
// 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗? 
// Related Topics 二分查找 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLIS(int[] nums) {
        int size = nums.length;
        if (size < 2) return size;
        int result = 1;
        int[] dp = new int[size];
        dp[0] = 1;
        for (int i = 1; i < size; ++i) {
            int max = 0;
            for (int j = 0; j < i; ++j)
                if (nums[j] < nums[i])
                    max = Math.max(max, dp[j]);
            dp[i] = max + 1;
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
