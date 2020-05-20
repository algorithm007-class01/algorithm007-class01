#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/maximal-rectangle/
题目描述
85. Maximal Rectangle
Hard
Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

Example:

Input:
[
  ["1","0","1","0","0"],
  ["1","0","1","1","1"],
  ["1","1","1","1","1"],
  ["1","0","0","1","0"]
]
Output: 6
"""

from typing import List


class Solution:
    def maximalRectangle(self, matrix: List[List[str]]) -> int:
        if not matrix or not matrix[0]: return 0

        ans = 0
        cols = len(matrix[0])

        heights = [0] * (cols + 1)
        for row in matrix:
            for j in range(cols):
                heights[j] = (heights[j] + 1) if row[j] == '1' else 0

            # 计算最大矩形面积
            stack = [-1]
            for j in range(cols + 1):
                while heights[stack[-1]] > heights[j]:
                    top = stack.pop()
                    ans = max(ans, heights[top] * (j - stack[-1] - 1))
                stack.append(j)
        return ans


print(Solution().maximalRectangle(
    [
        ["1", "0", "1", "0", "0"],
        ["1", "0", "1", "1", "1"],
        ["1", "1", "1", "1", "1"],
        ["1", "0", "0", "1", "0"]
    ]
))
