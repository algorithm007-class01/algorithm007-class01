class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        # DP O n2
        # if not nums:
        #     return 0
        # N = len(nums)
        # dp = [0 for _ in range(N)]
        # for i in range(1, N):
        #     for j in range(i):
        #         if nums[i] > nums[j]:
        #             dp[i] = max(dp[i], dp[j]+1)
        # # print(dp)
        # return max(dp)+1
        # 贪心
        N = len(nums)
        res = []
        for i in range(N):
            if not res or nums[i] > res[-1]:
                res.append(nums[i])
            else:
                # 二分查找优化
                for j in range(len(res)):
                    if res[j]>=nums[i]:
                        res[j] = nums[i]
                        break 
        return len(res)
                
