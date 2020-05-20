#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/partition-equal-subset-sum/
题目描述
416. Partition Equal Subset Sum
Medium
Given a non-empty array containing only positive integers,
find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

Note:

Each of the array element will not exceed 100.
The array size will not exceed 200.

Example 1:
Input: [1, 5, 11, 5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].

Example 2:
Input: [1, 2, 3, 5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.
"""

from typing import List


class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        # 解法1 动态规划, 转化为背包问题
        if not nums: return False
        s = sum(nums)
        if s & 1: return False
        s >>= 1

        dp = [([0] * (s + 1)) for _ in range(len(nums))]
        for i in range(len(nums)):
            dp[i][0] = 1
        if nums[0] < s:
            dp[0][nums[0]] = 1
        elif nums[0] == s:
            return True

        for i in range(1, len(nums)):
            for j in range(1, s + 1):  # todo 优化空间复杂度
                if dp[i - 1][j] or (j >= nums[i] and dp[i - 1][j - nums[i]] == 1):
                    dp[i][j] = 1
                if dp[i][-1] == 1:
                    return True
        return False

        # 解法2 DFS深度遍历
        # if not nums or len(nums) < 2: return False
        # s = sum(nums)
        # if s & 1: return False
        # s >>= 1
        # nums.sort(reverse=True)  # todo 从大到小排序, 加快查找速度, 尽快的排除不可能的情况, 否则会超时
        #
        # def _dfs(i, s1, s2):
        #     if i >= len(nums): return False
        #     if s1 > s or s2 > s: return False
        #     if s1 == s or s2 == s: return True
        #     return _dfs(i + 1, s1 + nums[i], s2) or _dfs(i + 1, s1, s2 + nums[i])
        #
        # ans = _dfs(0, 0, 0)
        # return ans


print(Solution().canPartition([1, 1]))
print(Solution().canPartition([1, 5, 11, 5]))
print(Solution().canPartition([1, 2, 3, 5]))
