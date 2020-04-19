# 戳气球
# 有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
# 现在要求你戳破所有的气球。每当你戳破一个气球 i 时，你可以获得 nums[left] * nums[i] * nums[right] 个硬币。 这里的 left 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。
# 求所能获得硬币的最大数量。
# 动态规划
# 预处理 nums = [1] + nums + [1], 给原数组首尾添加1, 并设新的数组大小为n
# 区间dp是按照区间最后一个被扎破的气球对问题划分，找到所有可能中最大值
# dp[i][j]代表删除nums[i+1,..., j-1]之后的最大值，我们的目标是求dp[0][n-1]。
# 动态转移方程：dp[i][j] = max(dp[i][k-1] + dp[k+1][j] + nums[i]*nums[k]*nums[j],dp[i][j])
# 初始化 d[i][i+2] = nums[i] * nums[i+1] * nums[i+2]
# 首先我们尝试每戳破一个气球，以该气球为边界将气球数组分为两部分，使用这两部分的解来求解原问题。
class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        nums = [1] + nums + [1]
        n = len(nums)
        dp = [[0]*n for i in range(n)]
        for i in range(n-1, -1, -1):
            for j in range(i+2, n):
                for k in range(i+1,k):
                    # # 由于dp[i][j]的定义是不戳破i和j，仅戳破ij之间的气球得到的最大值。
                        # 因此在算了dp[i][k]+dp[k][j]之后，其中ij之间仅剩ikj三个气球而已，
                        # 也就是可以理解为k是这个区间中最后一个戳破的气球，因此是+nums[i][k][j].
                    dp[i][step] = max(dp[i][k],dp[k][i+step] + nums[i]*nums[k]*nums[i+step],dp[i][i+step])
        return dp[0][-1]