#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/sudoku-solver/
题目描述
37. Sudoku Solver
Hard
Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
Empty cells are indicated by the character '.'.


A sudoku puzzle...
...and its solution numbers marked in red.

Note:
The given board contain only digits 1-9 and the character '.'.
You may assume that the given Sudoku puzzle will have a single unique solution.
The given board size is always 9x9.
"""

from typing import List


class Solution:
    def solveSudoku(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """

        if not board: return
        n = len(board)

        def box_idx(i, j):
            return i // 3 * (n // 3) + j // 3

        def _dfs(cnt):
            if cnt >= n * n:
                return True

            i, j = cnt // n, cnt % n
            if board[i][j] != '.':
                return _dfs(cnt + 1)

            for k in range(1, 10):
                k = str(k)
                if k in rows[i] or k in cols[j] or k in boxs[box_idx(i, j)]:
                    continue
                board[i][j] = k
                rows[i][k] = cols[j][k] = boxs[box_idx(i, j)][k] = 1
                if _dfs(cnt + 1): return True
                # reverse state
                rows[i].pop(k)
                cols[j].pop(k)
                boxs[box_idx(i, j)].pop(k)
            # todo reverse state
            board[i][j] = '.'
            return False

        # init
        rows = [{} for _ in range(n)]
        cols = [{} for _ in range(n)]
        boxs = [{} for _ in range(n)]
        for i in range(n):
            for j in range(n):
                if board[i][j] == '.': continue
                k = board[i][j]
                rows[i][k] = cols[j][k] = boxs[box_idx(i, j)][k] = 1
        _dfs(0)
        return


print(Solution().solveSudoku(
    [["5", "3", ".", ".", "7", ".", ".", ".", "."],
     ["6", ".", ".", "1", "9", "5", ".", ".", "."],
     [".", "9", "8", ".", ".", ".", ".", "6", "."],
     ["8", ".", ".", ".", "6", ".", ".", ".", "3"],
     ["4", ".", ".", "8", ".", "3", ".", ".", "1"],
     ["7", ".", ".", ".", "2", ".", ".", ".", "6"],
     [".", "6", ".", ".", ".", ".", "2", "8", "."],
     [".", ".", ".", "4", "1", "9", ".", ".", "5"],
     [".", ".", ".", ".", "8", ".", ".", "7", "9"]]
))
