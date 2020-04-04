#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/permutations-ii/
题目描述
47. Permutations II
Medium
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:
Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
"""

from typing import List


class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        # # 解法1 回溯 + 适当剪枝 + set去重
        # if not nums: return [[]]
        # nums.sort()
        #
        # def _backtrace(s):
        #     # terminator
        #     if s == len(nums):
        #         ans.add(tuple(nums[:]))
        #         return
        #     # process
        #     for i in range(s, len(nums)):
        #         if i > s and nums[i] == nums[i - 1]:
        #             continue   # todo 剪枝
        #         nums[s], nums[i] = nums[i], nums[s]
        #         # drill down
        #         _backtrace(s + 1)
        #         # reverse state
        #         nums[s], nums[i] = nums[i], nums[s]
        #     return
        #
        # ans = set()
        # _backtrace(0)
        # return list(ans)

        # 解法2 递归遍历所有可能组合, 去重
        if not nums: return [()]
        perms = [(p[:i] + (nums[0],) + p[i:]) for p in self.permuteUnique(nums[1:]) for i in range(len(p) + 1)]
        return list(set(perms))


res = Solution().permuteUnique([0, 1, 0, 0, 9])
print(res)
