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
        # # 解法1 动态规划
        # if not nums: return 0
        # f1 = 0
        # f2 = nums[0]
        # for i in range(1, len(nums)):
        #     f2, f1 = max(nums[i] + f1, f2), f2
        #
        # return f2

        # 解法1.1 动态规划
        if not nums: return 0
        dp = [0, 0]     # index=0不抢, index=1抢
        for i in range(len(nums)):
            dp = [max(dp), dp[0] + nums[i]]
        return max(dp)

        # # 解法2 回溯 超时
        # if not nums: return 0
        # if len(nums) <= 2: return max(nums)
        #
        # # 抢 | 不抢
        # return max(nums[0] + self.rob(nums[2:]), self.rob(nums[1:]))

        # # 解法2.1 回溯+缓存记忆
        # if not nums: return 0
        #
        # def _rob(i):
        #     if i >= len(nums): return 0
        #     if i in memo: return memo[i]
        #
        #     # 抢 | 不抢
        #     memo[i] = max(nums[i] + _rob(i + 2), _rob(i + 1))
        #     return memo[i]
        #
        # memo = {}
        # ans = _rob(0)
        # return ans


print(Solution().rob([1, 2, 3, 1]))
print(Solution().rob([2, 7, 9, 3, 1]))
