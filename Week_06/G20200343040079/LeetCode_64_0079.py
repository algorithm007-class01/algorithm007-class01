#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/minimum-path-sum/
题目描述
64. Minimum Path Sum
Medium
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right
which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
Example:
Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.
"""

from typing import List


class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:

        # 解法1 动态规划
        # 定义状态 dp[i][j] = minPath(A[0->i][0->j])
        # dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + A[i][j]

        if not grid or not grid[0]: return 0
        rows, cols = len(grid), len(grid[0])
        for i in range(1, rows):
            grid[i][0] += grid[i-1][0]
        for j in range(1, cols):
            grid[0][j] += grid[0][j-1]

        for i in range(1, rows):
            for j in range(1, cols):
                grid[i][j] += min(grid[i-1][j], grid[i][j-1])
        return grid[-1][-1]
