#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/n-queens-ii/
题目描述
52. N-Queens II
Hard
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
Given an integer n, return the number of distinct solutions to the n-queens puzzle.
Example:
Input: 4
Output: 2
Explanation: There are two distinct solutions to the 4-queens puzzle as shown below.
[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
"""


class Solution:
    def totalNQueens(self, n: int) -> int:
        if n <= 0: return 0

        def _dfs(row, cols, pie, na):
            if row >= n:
                nonlocal ans
                ans += 1
                print('--->', bin(cols)[2:][-n:].zfill(4), bin(pie)[2:][-n:].zfill(4), bin(na)[2:][-n:].zfill(4))
                return

            print(bin(cols)[2:][-n:].zfill(4), bin(pie)[2:][-n:].zfill(4), bin(na)[2:][-n:].zfill(4))

            bits = (~(cols | pie | na) & ((1 << n) - 1))
            while bits:
                p = bits & -bits    # 得到最低位的1
                bits = bits & (bits - 1)    # 清空最低位的1
                _dfs(row + 1, cols | p, (pie | p) << 1, (na | p) >> 1)
                # reverse state
            return

        ans = 0
        _dfs(0, 0, 0, 0)
        return ans


Solution().totalNQueens(4)
