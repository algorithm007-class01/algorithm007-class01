#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/permutations/
题目描述
46. Permutations
Medium
Given a collection of distinct integers, return all possible permutations.

Example:
Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
"""

from typing import List


class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        # # 解法1 类似DP插入法, 逐步生成序列
        # if not nums: return [[]]
        # s = [[]]
        # for n in nums:
        #     s = [(p[:i] + [n] + p[i:]) for p in s for i in range(len(p) + 1)]
        # return s

        # # 解法2 将问题化解为子问题, 递归解决
        # if not nums: return [[]]
        # perms = [(p[:i] + [nums[0]] + p[i:]) for p in self.permute(nums[1:]) for i in range(len(p) + 1)]
        # return perms

        # # 解法3 reduce
        # if not nums: return [[]]
        # from functools import reduce
        # s = reduce(lambda s, n: [p[:i] + [n] + p[i:] for p in s for i in range(len(p) + 1)], nums, [[]])
        # return s

        # 解法4 回溯
        if not nums: return [[]]
        def _backtrace(start):
            # terminator
            if start == len(nums):
                ans.append(nums[:])
                return
            # process
            for i in range(start, len(nums)):
                nums[i], nums[start] = nums[start], nums[i]
                # drill down
                _backtrace(start + 1)
                # reverse state
                nums[i], nums[start] = nums[start], nums[i]
        ans = []
        _backtrace(0)
        return ans


res = Solution().permute([1, 2, 3])
print(res)
