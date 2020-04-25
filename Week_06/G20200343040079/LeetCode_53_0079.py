#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/maximum-subarray/
题目描述
53. Maximum Subarray
Easy
Given an integer array nums, find the contiguous subarray (containing at least one number)
which has the largest sum and return its sum.

Example:
Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:
If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach,
which is more subtle.
"""

from typing import List


class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        # # 解法1 动态规划
        # # dp[i] 算上nums[i]的最大连续子数组和
        # if len(nums) < 1: return 0
        # dp = [0] * len(nums)
        # ans = dp[0] = nums[0]
        # for i in range(1, len(nums)):
        #     dp[i] = max(nums[i], dp[i - 1] + nums[i])
        #     ans = max(ans, dp[i])
        # return ans

        # 解法1.1 动态规划-状态压缩, 空间复杂度O(1)
        if not nums: return 0
        ans = dp = nums[0]
        for i in range(1, len(nums)):
            dp = max(nums[i], nums[i] + dp)
            ans = max(ans, dp)
        return ans

        # 解法2 分治法？
        # 效率不是很好


print(Solution().maxSubArray([-2, 1]))
