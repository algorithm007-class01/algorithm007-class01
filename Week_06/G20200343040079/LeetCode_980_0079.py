#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/unique-paths-iii/
题目描述
980. Unique Paths III
Hard
On a 2-dimensional grid, there are 4 types of squares:

1 represents the starting square.  There is exactly one starting square.
2 represents the ending square.  There is exactly one ending square.
0 represents empty squares we can walk over.
-1 represents obstacles that we cannot walk over.
Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.

Example 1:
Input: [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
Output: 2
Explanation: We have the following two paths:
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
Example 2:
Input: [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
Output: 4
Explanation: We have the following four paths:
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
Example 3:
Input: [[0,1],[2,0]]
Output: 0
Explanation:
There is no path that walks over every empty square exactly once.
Note that the starting and ending square can be anywhere in the grid.
Note:
1 <= grid.length * grid[0].length <= 20
"""

from typing import List


class Solution:
    def uniquePathsIII(self, grid: List[List[int]]) -> int:
        if not grid or not grid[0]: return 0

        rows, cols = len(grid), len(grid[0])
        # find start | find end
        start = end = None
        zeros = 0
        for i in range(rows):
            for j in range(cols):
                if grid[i][j] == 1:
                    start = (i, j)
                    grid[i][j] = 0
                    zeros += 1
                elif grid[i][j] == 2: end = (i, j)
                elif grid[i][j] == 0: zeros += 1

        def _dfs(i, j, zs):
            # terminator
            if not (0 <= i < rows and 0 <= j < cols): return
            if (i, j) == end:
                if zs == zeros: self.ans += 1
                return
            if grid[i][j] == -1: return

            # print(i, j)
            # process
            grid[i][j] = -1
            directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]
            for d in directions:
                # drill down
                _dfs(i + d[0], j + d[1], zs + 1)

            # reverse state
            grid[i][j] = 0
            return

        self.ans = 0
        _dfs(*start, 0)
        return self.ans
