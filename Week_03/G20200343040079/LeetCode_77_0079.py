#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/combinations/
题目描述
77. Combinations
Medium
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example:
Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
"""

from typing import List


class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        # # 解法1 递归遍历
        # if k >= n: return [[i+1 for i in range(n)]]
        #
        # def _combine(start, cur_nums):
        #     if len(cur_nums) == k:
        #         ans.append(cur_nums)
        #         return
        #
        #     for i in range(start, n+1):
        #         _combine(i + 1, cur_nums + [i])
        #     return
        # ans = []
        # _combine(1, [])
        # return ans

        # 解法2 递归的另一种传值方式
        # if k >= n: return [[i+1 for i in range(n)]]
        #
        # def _combine(start, cur_nums):
        #     if len(cur_nums) == k:
        #         ans.append(cur_nums[:])
        #         return
        #
        #     # 剪枝
        #     if n - start + 1 < k - len(cur_nums):
        #         return
        #
        #     for i in range(start, n+1):
        #         cur_nums.append(i)
        #         _combine(i + 1, cur_nums)
        #         cur_nums.pop()
        #     return
        # ans = []
        # _combine(1, [])
        # return ans

        # # 解法3 dp解决
        # if k >= n: return [[i+1 for i in range(n)]]
        #
        # ans = []
        # lst = [()]
        # for i in range(1, n+1):
        #     for j in range(len(lst)): # 遍历列表时, 修改列表, 要小心
        #         new = lst[j] + (i,)
        #         if len(new) >= k: ans.append(new)
        #         else:lst.append(new)
        # return ans

        # # 解法4 DP递归 子问题分解
        # # dp[n, k] = {n + dp[n-1, k-1]} + {dp[n-1, k]}
        # if k <= 0: return [[]]
        # if k >= n: return [[i + 1 for i in range(n)]]
        #
        # dp0 = [[n] + v for v in self.combine(n-1, k-1)]
        # dp1 = self.combine(n-1, k)
        # return dp0 + dp1

        # 解法5 生成所有组合, 再筛选
        if k >= n: return [[i + 1 for i in range(n)]]
        from functools import reduce
        ans = reduce(lambda lst, n: lst + [l + (n,) for l in lst], range(1, n + 1), [()])
        return [v for v in ans if len(v) == k]


res = Solution().combine(3, 2)
print(res)

res = Solution().combine(4, 2)
print(res)
