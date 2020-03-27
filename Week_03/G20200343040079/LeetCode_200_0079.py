#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
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


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        # # 解法1 染色
        if not grid or not grid[0]: return 0

        # def _dfs_flood_fill(i, j):
        #     """DFS遍历染色"""
        #     if not (0 <= i < rows and 0 <= j < cols) or grid[i][j] != '1':
        #         return
        #     grid[i][j] = '0'
        #     _flood_fill(i + 1, j)
        #     _flood_fill(i - 1, j)
        #     _flood_fill(i, j + 1)
        #     _flood_fill(i, j - 1)
        #     return
        def _bfs_flood_fill(i, j):
            """BFS遍历染色"""
            if not (0 <= i < rows and 0 <= j < cols) or grid[i][j] != '1':
                return
            from collections import deque
            queue = deque([(i, j)])
            while queue:
                i, j = queue.popleft()
                grid[i][j] = '0'
                directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]
                for d in directions:
                    x, y = i + d[0], j + d[1]
                    if 0 <= x < rows and 0 <= y < cols and grid[x][y] == '1':
                        queue.appendleft((x, y))
            return

        rows, cols = len(grid), len(grid[0])
        cnt = 0
        for i in range(rows):
            for j in range(cols):
                if grid[i][j] == '1':
                    cnt += 1
                    # _dfs_flood_fill(i, j)
                    _bfs_flood_fill(i, j)
        return cnt

        # 解法2 并查集
        pass


cnt = Solution().numIslands(
    [["1", "1", "1", "1", "0"],
     ["1", "1", "0", "1", "0"],
     ["1", "1", "0", "0", "0"],
     ["0", "0", "0", "0", "0"]])
print(cnt)
