#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/generate-parentheses/
题目描述
78. Subsets
Medium
Given a set of distinct integers, nums, return all possible subsets (the power set).
Note: The solution set must not contain duplicate subsets.

Example:
Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
"""

from typing import List


class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        # # 解法1 迭代解法
        # if not nums: return [[]]
        # subs = [[]]
        # for n in nums:
        #     subs += [s + [n] for s in subs]
        # return subs

        # 解法1.1 迭代精简写法
        # from functools import reduce
        # ans = reduce(lambda s, n: s + [v+[n] for v in s], nums, [[]])
        # return ans

        # # 解法2 递归解法
        # if not nums: return [[]]
        # subs = self.subsets(nums[1:])
        # return subs + [s + [nums[0]] for s in subs]

        # # 解法3 回溯
        # if not nums: return [[]]
        # def _backtrace(start, lst):
        #     if start >= len(nums):
        #         ans.append(lst)
        #         return
        #     # 选
        #     _backtrace(start + 1, [nums[start]] + lst)
        #     # 不选
        #     _backtrace(start + 1, lst)
        #     return
        # ans = []
        # _backtrace(0, [])
        # return ans

        # 解法4 回溯, 不拷贝整个变量
        if not nums: return [[]]

        def _backtrace(index, path):
            # terminator
            if index == len(nums):
                ans.append(path[:])
                return

            # process
            # 不选
            _backtrace(index + 1, path)            # drill down
            # 选
            path.append(nums[index])    # process
            _backtrace(index + 1, path)            # drill down
            path.pop()                  # reverse state
            return

        ans = []
        _backtrace(0, [])
        return ans


res = Solution().subsets([1, 2, 3])
print(res)
