#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/n-queens/
题目描述
51. N-Queens
Hard
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
Given an integer n, return all distinct solutions to the n-queens puzzle.
Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.'
both indicate a queen and an empty space respectively.

Example:
Input: 4
Output: [
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
"""

from typing import List


class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        # # 解法1 递归回溯
        # if n <= 0: return [['']]
        #
        # def _dfs(row, path):
        #     """递归: 回溯"""
        #     # terminator
        #     if row == n:
        #         ans.append(['.' * c + 'Q' + (n - c - 1) * '.' for c in path])   # format_result
        #         return
        #
        #     for col in range(n):
        #         if col in cols or (row + col) in pie or (row - col) in na:
        #             continue
        #         cols.add(col)
        #         pie.add(row + col)
        #         na.add(row - col)
        #         # process
        #         path.append(col)
        #         # drill down
        #         _dfs(row + 1, path)
        #         # reverse state
        #         cols.remove(col)
        #         pie.remove(row + col)
        #         na.remove(row - col)
        #         path.pop()
        #     return
        #
        # cols, pie, na = set(), set(), set()     # y, xy_sum, xy_diff
        # ans = []
        # _dfs(0, [])
        # return ans

        # 解法1.1 递归回溯 不同的传参方式
        if n <= 0: return [['']]

        def _dfs(cols, pie, na):
            """递归: 回溯"""
            row = len(cols)
            # terminator
            if row == n:
                ans.append(['.' * c + 'Q' + (n - c - 1) * '.' for c in cols])   # format_result
                return

            # process
            for col in range(n):
                if not (col in cols or (row + col) in pie or (row - col) in na):
                    # drill down
                    _dfs(cols + [col], pie + [row + col], na + [row - col])
                    # reverse state
            return

        ans = []
        _dfs([], [], [])
        return ans

        # todo 解法2 用二进制位优化标志
        # N皇后问题, 本质是全排列+剪枝, 可以边遍历边剪枝, 也可以遍历到最后判断是否符合条件
        # 回溯法就是多叉树遍历问题
