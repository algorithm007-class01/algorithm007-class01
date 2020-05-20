#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/distinct-subsequences/
题目描述
115. Distinct Subsequences
Hard
Given a string S and a string T, count the number of distinct subsequences of S which equals T.
A subsequence of a string is a new string which is formed from the original string by deleting
some (can be none) of the characters without disturbing the relative positions of the remaining characters.
(ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

It's guaranteed the answer fits on a 32-bit signed integer.

Example 1:

Input: S = "rabbbit", T = "rabbit"
Output: 3
Explanation:
As shown below, there are 3 ways you can generate "rabbit" from S.
(The caret symbol ^ means the chosen letters)

rabbbit
^^^^ ^^
rabbbit
^^ ^^^^
rabbbit
^^^ ^^^
Example 2:

Input: S = "babgbag", T = "bag"
Output: 5
Explanation:
As shown below, there are 5 ways you can generate "bag" from S.
(The caret symbol ^ means the chosen letters)

babgbag
^^ ^
babgbag
^^    ^
babgbag
^    ^^
babgbag
  ^  ^^
babgbag
    ^^^
"""

from typing import List


class Solution:
    def numDistinct(self, s: str, t: str) -> int:
        # 解法1 动态规划
        if not t: return 1
        if not s: return 0

        rows, cols = len(s) + 1, len(t) + 1
        dp = [[0] * cols for _ in range(rows)]
        for j in range(1, cols):
            dp[0][j] = 0
        for i in range(rows):
            dp[i][0] = 1
        for i in range(1, rows):
            for j in range(1, cols):
                if s[i-1] == t[j-1]:        # 大问题拆解为小问题
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-1]
                else:
                    dp[i][j] = dp[i-1][j]

        return dp[-1][-1]
