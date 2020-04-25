#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/number-of-islands/
题目描述
200. Number of Islands
Medium
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3
"""

from typing import List


class DisjointSet:
    def __init__(self, grid):
        rows, cols = len(grid), len(grid[0])
        self.parent = [i for i in range(rows * cols)]
        self.count = len([grid[i][j] for i in range(rows) for j in range(cols) if grid[i][j] == '1'])

    def union(self, i, j):
        p1 = self.find(i)
        p2 = self.find(j)
        if p1 != p2:
            self.parent[p1] = p2
            self.count -= 1
        return

    def find(self, i):
        root = i
        while self.parent[root] != root:
            root = self.parent[root]
        while self.parent[i] != i:  # 路径压缩
            self.parent[i], i = root, self.parent[i]
        return root


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid: return 0
        disjoint_set = DisjointSet(grid)

        rows, cols = len(grid), len(grid[0])
        for i in range(rows):
            for j in range(cols):
                if grid[i][j] != '1': continue
                for d in [(1, 0), (-1, 0), (0, 1), (0, -1)]:
                    x, y = i + d[0], j + d[1]
                    if 0 <= x < rows and 0 <= y < cols and grid[x][y] == '1':
                        disjoint_set.union(i * cols + j, x * cols + y)
        return disjoint_set.count


print(Solution().numIslands(
    [["1", "0", "1", "1", "1"],
     ["1", "0", "1", "0", "1"],
     ["1", "1", "1", "0", "1"]]
))
