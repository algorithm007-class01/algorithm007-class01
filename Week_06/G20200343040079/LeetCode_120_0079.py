#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/triangle/
题目描述
120. Triangle
Medium
Given a triangle, find the minimum path sum from top to bottom.
Each step you may move to adjacent numbers on the row below.
For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space,
where n is the total number of rows in the triangle.
"""

from typing import List


class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        # # 解法1 动态规划, 由小问题推导大问题的解
        # # 总结: 本题包含重复子问题, 本质是用子问题的最优解推导大问题的最优解
        # if not triangle or not triangle[0]: return 0
        #
        # dp = triangle[-1][:]    # 只申请了一个一维数组, 状态压缩
        # for i in range(len(triangle) - 2, -1, -1):
        #     for j in range(len(triangle[i])):
        #         dp[j] = triangle[i][j] + min(dp[j], dp[j + 1])
        # return dp[0]

        # 解法2 递归+缓存
        if not triangle: return 0

        def _dfs(i, j):
            if i == len(triangle) - 1:
                return triangle[i][j]
            if (i, j) in memo: return memo[(i, j)]
            memo[(i, j)] = triangle[i][j] + min(_dfs(i + 1, j), _dfs(i + 1, j + 1))
            return memo[(i, j)]

        memo = {}
        return _dfs(0, 0)


res = Solution().minimumTotal([
    [2],
    [3, 4],
    [6, 5, 7],
    [4, 1, 8, 3]
])
print(res)
