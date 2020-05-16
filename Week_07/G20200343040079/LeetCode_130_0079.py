#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/surrounded-regions/
题目描述
130. Surrounded Regions
Medium
Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:

X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
Explanation:

Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'.
Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'.
Two cells are connected if they are adjacent cells connected horizontally or vertically.
"""

from typing import List


class DisjointSet:
    def __init__(self, n):
        self.parent = [i for i in range(n)]
        self.count = n

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
    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        # # 解法1 并查集
        # if not board: return
        #
        # rows, cols = len(board), len(board[0])
        # disjoint_set = DisjointSet(rows * cols)
        # for i in range(rows):
        #     for j in range(cols):
        #         if board[i][j] != 'O': continue
        #         for d in [(1, 0), (-1, 0), (0, 1), (0, -1)]:
        #             x, y = i + d[0], j + d[1]
        #             if 0 <= x < rows and 0 <= y < cols and board[x][y] == 'O':
        #                 disjoint_set.union(i * cols + j, x * cols + y)
        #
        # board_set = set()
        # for i in range(rows):
        #     for j in [0, cols - 1]:
        #         if board[i][j] == 'O':
        #             board_set.add(disjoint_set.find(i * cols + j))
        # for i in [0, rows - 1]:
        #     for j in range(1, cols - 1):
        #         if board[i][j] == 'O':
        #             board_set.add(disjoint_set.find(i * cols + j))
        # for i in range(1, rows - 1):
        #     for j in range(1, cols - 1):
        #         if board[i][j] == 'O' and disjoint_set.find(i * cols + j) not in board_set:
        #             board[i][j] = 'X'
        # return

        # 解法2 DFS
        # if not board: return
        #
        # def _dfs(i, j):
        #     if not (0 <= i < rows and 0 <= j < cols): return
        #     if board[i][j] != 'O': return
        #
        #     board[i][j] = '#'
        #     for d in [(1, 0), (-1, 0), (0, 1), (0, -1)]:
        #         x, y = i + d[0], j + d[1]
        #         _dfs(x, y)
        #     return
        #
        # rows, cols = len(board), len(board[0])
        # for i in range(rows):
        #     for j in [0, cols - 1]:
        #         if board[i][j] == 'O':
        #             _dfs(i, j)
        # for i in [0, rows - 1]:
        #     for j in range(1, cols - 1):
        #         if board[i][j] == 'O':
        #             _dfs(i, j)
        # for i in range(rows):
        #     for j in range(cols):
        #         if board[i][j] == 'O': board[i][j] = 'X'
        #         if board[i][j] == '#': board[i][j] = 'O'
        # return

        # 解法3 BFS
        if not board: return
        rows, cols = len(board), len(board[0])

        def _bfs(i, j):
            if not (0 <= i < rows and 0 <= j < cols): return
            if board[i][j] != 'O': return
            from collections import deque
            q = deque([(i, j)])
            visited.add((i, j))     # todo 这里首先add进去
            while q:
                i, j = q.popleft()
                board[i][j] = '#'
                for d in [(1, 0), (-1, 0), (0, 1), (0, -1)]:
                    x, y = i + d[0], j + d[1]
                    if (0 <= x < rows and 0 <= y < cols) and board[x][y] == 'O' and (x, y) not in visited:
                        visited.add((x, y))     # todo 不要忘了这里的add
                        q.append((x, y))
            return

        visited = set()
        for i in range(rows):
            for j in [0, cols - 1]:
                if board[i][j] == 'O':
                    _bfs(i, j)
        for i in [0, rows - 1]:
            for j in range(1, cols - 1):
                if board[i][j] == 'O':
                    _bfs(i, j)
        for i in range(rows):
            for j in range(cols):
                if board[i][j] == 'O': board[i][j] = 'X'
                if board[i][j] == '#': board[i][j] = 'O'
        return


print(Solution().solve(

    [['X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'],
     ['O', 'X', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'X'],
     ['O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X'],
     ['O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O'],
     ['O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'X'],
     ['X', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'X', 'O', 'X', 'O', 'X', 'O', 'X', 'O'],
     ['O', 'O', 'O', 'O', 'X', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'X', 'O', 'O', 'O'],
     ['X', 'O', 'O', 'O', 'X', 'X', 'X', 'O', 'X', 'O', 'O', 'O', 'O', 'X', 'X', 'O', 'X', 'O', 'O', 'O'],
     ['O', 'O', 'O', 'O', 'O', 'X', 'X', 'X', 'X', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'X', 'O', 'O', 'O'],
     ['X', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'X', 'O', 'O', 'X', 'O', 'O', 'X'],
     ['O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'X', 'O', 'O', 'O', 'X', 'O', 'X'],
     ['O', 'O', 'O', 'O', 'X', 'O', 'X', 'O', 'O', 'X', 'X', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O'],
     ['X', 'X', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'],
     ['O', 'X', 'O', 'X', 'O', 'O', 'O', 'X', 'O', 'X', 'O', 'O', 'O', 'X', 'O', 'X', 'O', 'X', 'O', 'O'],
     ['O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'X', 'O'],
     ['X', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'X', 'X', 'O', 'O', 'O', 'X', 'O', 'O'],
     ['O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'X', 'O', 'X', 'O', 'X', 'O', 'O'],
     ['O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'X', 'X', 'X', 'O', 'O', 'X', 'O', 'O', 'O', 'X', 'O'],
     ['O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'],
     ['X', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'X', 'X', 'O', 'O', 'X', 'O', 'X', 'O', 'X', 'O', 'O']]
))
