# 给定一个非负整数数组和一个整数 m，你需要将这个数组分成 m 个非空的连续子数组。设计一个算法使得这 m 个子数组各自和的最大值最小。
# nums=[7,2,5,8,10],m=2，求子数组各自和中的最大值，然后求这些最大值中的最小值
# 将该数组分成两组，分别是[7]和[2,5,8,10];[7,2]和[5,8,10];[7,2,5]和[8,10]以及[7,2,5,8]和10
# 上述子数组的最大值分别是25,23,18,22，最小的是18

# 状态数组 dp[i][j]表示数组nums[0]到nums[j]j+1个元素划分为i组的和的最大最小值
# 状态迁移方程：dp[i][j] = min(max(dp[i-1][k], sum(k+1, j))), 0<= k < j
# 在右边划一段出来，先把问题规模-1，然后剩下的只需要再切分i-1组即可,其中k是缩小问题规模的切分点
# 可初始化状态：dp[1][j]表示nums[0]~nums[j]划分为1组的分组和的最大最小值，显然dp[1][j] = sum(0, j)，包含边界。
class Solution(object):
    def splitArray(self, nums, m):
        n = len(nums)
        presum = [0] * n
        presum[0] = nums[0]
        # presum每个位置存储的是数组nums的前i个位置的和
        # 因为子数组要求非空连续，因此在划分时，可能出现第一个划分的组的和就是presum中的值
        for i in range(1,n):
            presum[i] = presum[i-1] + nums[i]
        # dp[i][j]表示从nums[0]到nums[j]分成i个组的解
        # 当i=0,dp[0][j]代表分成0组，和是0
        dp = [[float('inf')]*n for i in range(m+1)]
        # dp[1][j] = sum(0,j),前nums[0]到nums[j]分成一组，求和
        for j in range(n):
            dp[1][j] = presum[j]
        # 分成m组，与分成m-1组，m-2组,....，2组的状态相关，所有需要遍历
        # 
        for i in range(2,m+1):
            for j in range(i-1,len(nums)):
                for k in range(0,j):
                    dp[i][j] = min(dp[i][j],max(dp[i-1][k],presum[j]-presum[k]))
        return dp[m][len(nums)-1]