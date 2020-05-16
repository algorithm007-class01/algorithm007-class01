#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/house-robber/
题目描述
198. House Robber
Easy
You are a professional robber planning to rob houses along a street.
Each house has a certain amount of money stashed, the only constraint stopping you
from robbing each of them is that adjacent houses have security system connected
and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house,
determine the maximum amount of money you can rob tonight without alerting the police.

Example 1:
Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.
Example 2:
Input: [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
             Total amount you can rob = 2 + 9 + 1 = 12.
"""

from typing import List


class Solution:
    def rob(self, nums: List[int]) -> int:
        # # 解法1.1 动态规划
        # # 定义dp状态, dp[i][0] -> 第i天没有偷, dp[i][1] -> 第i天偷了
        # # 递推公式:
        # # dp[i][0] = max(dp[i-1][0], dp[i-1][1])
        # # dp[i][1] = dp[i-1][0] + nums[i]
        # if not nums: return 0
        # dp = [[0] * 2 for _ in range(len(nums))]
        # for i, n in enumerate(nums):
        #     dp[i][0] = max(dp[i-1])
        #     dp[i][1] = dp[i-1][0] + n
        # return max(dp[-1])

        # 解法1.2 动态规划 & 状态压缩
        if not nums: return 0
        dp = [0, 0]                 # 0不抢, 1抢
        for i in range(len(nums)):
            dp = [max(dp), dp[0] + nums[i]]
        return max(dp)

        # # 解法1.3 动态规划, 定义另一种动态递推公式
        # # 用两个变量进行递推, 不如前两种具有通用性
        # # 递推公式: dp[i] = max(dp[i-2] + nums[i], dp[i-1])
        # if not nums: return 0
        # f1 = 0
        # f2 = nums[0]
        # for i in range(1, len(nums)):
        #     f2, f1 = max(nums[i] + f1, f2), f2
        # return f2

        # # 解法2 回溯 超时
        # if not nums: return 0
        # if len(nums) <= 2: return max(nums)
        # # 抢 | 不抢
        # return max(nums[0] + self.rob(nums[2:]), self.rob(nums[1:]))

        # # 解法2.1 回溯+缓存记忆
        # if not nums: return 0
        #
        # def _rob(i):
        #     if i >= len(nums): return 0
        #     if i in memo: return memo[i]
        #     # 抢 | 不抢
        #     memo[i] = max(nums[i] + _rob(i + 2), _rob(i + 1))
        #     return memo[i]
        #
        # memo = {}
        # ans = _rob(0)
        # return ans

        # # 解法2.2 DFS + 记忆化缓存, 带完整注释
        # if not nums: return 0
        # def _dfs(i):
        #     # terminator
        #     if i >= len(nums): return 0
        #     # check cache
        #     if i in memo:
        #         return memo[i]
        #     # process & drill down
        #     memo[i] = max(nums[i] + _dfs(i + 2), _dfs(i + 1))
        #     # reverse state
        #     return memo[i]
        #
        # memo = {}
        # ans = _dfs(0)
        # return ans


print(Solution().rob([1, 2, 3, 1]))
print(Solution().rob([2, 7, 9, 3, 1]))
