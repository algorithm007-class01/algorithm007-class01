#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/maximum-product-subarray/
题目描述
152. Maximum Product Subarray
Medium
Given an integer array nums, find the contiguous subarray within an array (containing at least one number)
which has the largest product.

Example 1:
Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Example 2:
Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
"""

from typing import List


class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        # # 解法1 两次双向遍历, 得到最大值
        # if not nums: return 0
        #
        # ans = float('-inf')
        # product = 1
        # for n in nums:
        #     product *= n
        #     ans = max(ans, product)
        #     if n == 0: product = 1
        #
        # product = 1
        # for n in nums[::-1]:
        #     product *= n
        #     ans = max(ans, product)
        #     if n == 0: product = 1
        # return ans

        # 解法2 动态规划
        # dp[i]状态定义: 包含nums[i]的max_product, 因为这个状态是可以递推的
        # 全局的解, 是max(dp[i][0])
        # todo 1. 找到可以递推的状态转移方程, 2. 全局最优解可以由每一步的最优解得到
        # 为什么这么定义转移状态？参考 leetcode 300
        if not nums: return
        dp = [[0] * 2 for _ in range(2)]  # 状态压缩 dp[0][0] max, dp[0][1] minus_max
        ans = dp[0][0] = dp[0][1] = nums[0]
        for i in range(1, len(nums)):
            n, p = i % 2, (i - 1) % 2
            dp[n][0] = max(dp[p][0] * nums[i], dp[p][1] * nums[i], nums[i])
            dp[n][1] = min(dp[p][0] * nums[i], dp[p][1] * nums[i], nums[i])
            ans = max(ans, dp[n][0])
        return ans


res = Solution().maxProduct([2, 3, -2, 4])
print(res)

res = Solution().maxProduct([-2, 0, -1])
print(res)
