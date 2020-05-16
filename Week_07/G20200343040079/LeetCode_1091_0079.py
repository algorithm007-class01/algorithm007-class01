#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/shortest-path-in-binary-matrix/
题目描述
1091. Shortest Path in Binary Matrix
Medium
In an N by N square grid, each cell is either empty (0) or blocked (1).

A clear path from top-left to bottom-right has length k if and only
if it is composed of cells C_1, C_2, ..., C_k such that:

Adjacent cells C_i and C_{i+1} are connected 8-directionally (ie.,
they are different and share an edge or corner)
C_1 is at location (0, 0) (ie. has value grid[0][0])
C_k is at location (N-1, N-1) (ie. has value grid[N-1][N-1])
If C_i is located at (r, c), then grid[r][c] is empty (ie. grid[r][c] == 0).
Return the length of the shortest such clear path from top-left to bottom-right.
If such a path does not exist, return -1.



Example 1:
Input: [[0,1],[1,0]]
Output: 2
Example 2:
Input: [[0,0,0],[1,1,0],[1,1,0]]
Output: 4
Note:
1 <= grid.length == grid[0].length <= 100
grid[r][c] is 0 or 1
"""

from typing import List


class Solution:
    def shortestPathBinaryMatrix(self, grid: List[List[int]]) -> int:
        # 解法1 广度优先遍历
        if not grid: return 0
        if grid[0][0] == 1 or grid[-1][-1] == 1: return -1

        rows, cols = len(grid), len(grid[0])
        for i in range(rows):
            for j in range(cols):
                if grid[i][j] == 1: grid[i][j] = -1

        grid[0][0] = 1
        from collections import deque
        q = deque([(0, 0, 1)])
        visited = {(0, 0)}
        while q:
            i, j, level = q.popleft()
            if i == rows - 1 and j == cols - 1: return level

            for d in [(1, 0), (1, 1), (1, -1), (0, 1), (0, -1), (-1, 0), (-1, 1), (-1, -1)]:
                x, y = i + d[0], j + d[1]
                if (0 <= x < rows and 0 <= y < cols) and (x, y) not in visited and grid[x][y] == 0:
                    q.append((x, y, level + 1))
                    visited.add((x, y))
                    grid[x][y] = min(grid[x][y], level + 1) if grid[x][y] != 0 else (level + 1)
        return -1

        # todo 解法2 A* 启发式搜索


print(Solution().shortestPathBinaryMatrix(
    [[0, 0, 1, 0, 0, 0, 0],
     [0, 1, 0, 0, 0, 0, 1],
     [0, 0, 1, 0, 1, 0, 0],
     [0, 0, 0, 1, 1, 1, 0],
     [1, 0, 0, 1, 1, 0, 0],
     [1, 1, 1, 1, 1, 0, 1],
     [0, 0, 1, 0, 0, 0, 0]]
))
