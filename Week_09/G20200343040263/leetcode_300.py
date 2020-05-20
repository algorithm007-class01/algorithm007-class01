# 最长上升子序列
# [10,9,2,5,3,7,101,18] 最长上升子序列是[2,3,7,101],因此是4
# 状态定义 dp[i]的值代表以num[i]结尾的最长子序列长度
# 状态转移方程: 设j属于[0,i),考虑每轮计算新的dp[i]时,遍历[0,i)，做出判断
# 1.当nums[i]>nums[j]时,则nums[i]可在已nums[j]为集合递增的序列中，因此序列长度为dp[j]+1
# 2.当nums[i]<=nums[j]时, nums[i]nums[i] 无法接在 nums[j]nums[j] 之后，此情况上升子序列不成立，跳过。
# 因此状态转移方程为 dp[i] = max(dp[i],dp[j]+1) for j in range(0,i)
# 初始状态：每个元素都可单独构成一个单调上升的子序列，因此都为1
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        if not nums: return 0
        n = len(nums)
        dp = [1] * n
        for i in range(n):
            for j in range(i):
                if nums[j] < nums[i]:
                    dp[i] = max(dp[i],dp[j]+1)
        return max(dp)