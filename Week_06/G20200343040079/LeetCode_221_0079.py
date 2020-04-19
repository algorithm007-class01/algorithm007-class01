#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/maximal-square/
题目描述
221. Maximal Square
Medium
Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
Example:
Input:
1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Output: 4
"""

from typing import List


class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        # # 解法1 遍历
        # if not matrix or not matrix[0]: return 0
        #
        # ans = 0
        # rows, cols = len(matrix), len(matrix[0])
        # for i in range(rows):
        #     for j in range(cols):
        #         if matrix[i][j] != '1': continue
        #         ans = max(ans, self._find_max_square(i, j, matrix, rows, cols))
        # return ans

        # 解法2 动态规划
        if not matrix or not matrix[0]: return 0
        rows, cols = len(matrix), len(matrix[0])
        max_len = 0
        dp = [[0] * (cols + 1) for _ in range(rows + 1)]
        for i in range(1, rows + 1):
            for j in range(1, cols + 1):
                if matrix[i-1][j-1] == '1':
                    dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1
                    max_len = max(max_len, dp[i][j])
        return max_len ** 2

    def _find_max_square(self, x, y, matrix, rows, cols):
        """辅助查找函数"""
        l = float('inf')
        i, j = x, y
        while i < rows and i < (x + l) and matrix[i][y] == '1':
            t = j
            while t < cols and matrix[i][t] == '1':
                t += 1
            l = min(l, t - j)
            i += 1
        l = min(l, i - x)
        return l * l


print(Solution().maximalSquare(
    [["1", "0", "1", "0", "0"],
     ["1", "0", "1", "1", "1"],
     ["1", "1", "1", "1", "1"],
     ["1", "0", "0", "1", "0"]]
))
