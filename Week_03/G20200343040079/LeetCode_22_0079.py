#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/generate-parentheses/
题目描述
22. Generate Parentheses
Medium
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:
[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
"""

from typing import List


class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        if n <= 0: return []

        def _generate(left, right, n, path):
            # terminator
            if left == right == n:
                res.append(path)
                return

            # process

            # drill down
            if left < n:
                _generate(left + 1, right, n, path + '(')
            if left > right:
                _generate(left, right + 1, n, path + ')')
            # reverse state
            return

        res = []
        _generate(0, 0, n, '')
        return res


res = Solution().generateParenthesis(3)
print(res)
