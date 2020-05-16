#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/edit-distance/
题目描述
72. Edit Distance
Hard
Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
You have the following 3 operations permitted on a word:
Insert a character
Delete a character
Replace a character
Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation:
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation:
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
"""


class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        # # 莱文斯坦距离
        # # 解法1 动态规划
        # # todo 定义状态dp[i][j], 缩小问题规模, 看转移到dp[i][j]需要什么样的状态, 不用考虑将来的状态
        # # 缩小问题规模很重要, 状态定义其实是缩小问题规模后的直接答案
        # if not word1 or not word2: return len(word1) or len(word2)
        #
        # rows = len(word1) + 1
        # cols = len(word2) + 1
        # dp = [[0] * cols for _ in range(rows)]
        #
        # # 初始化第一行和第一列
        # for j in range(cols): dp[0][j] = j
        # for i in range(rows): dp[i][0] = i
        # for i in range(1, rows):
        #     for j in range(1, cols):
        #         if word1[i - 1] == word2[j - 1]:    # todo 注意word 下标取值
        #             dp[i][j] = dp[i - 1][j - 1]
        #         else:
        #             dp[i][j] = 1 + min(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1])
        # return dp[-1][-1]

        # 解法2 DFS+缓存
        if not word1 or not word2: return len(word1) or len(word2)

        def _dfs(i, j):
            # terminator
            if i == len(word1): return len(word2) - j
            if j == len(word2): return len(word1) - i

            # check cache
            if (i, j) in memo: return memo[(i, j)]
            # process & drill down
            if word1[i] == word2[j]:
                memo[(i, j)] = _dfs(i + 1, j + 1)
            else:
                memo[(i, j)] = 1 + min(_dfs(i, j + 1), _dfs(i + 1, j), _dfs(i + 1, j + 1))
            # reverse state
            return memo[(i, j)]

        memo = {}
        ans = _dfs(0, 0)
        return ans

        # # 解法2.1 DFS+缓存
        # if not word1 or not word2: return len(word1) or len(word2)
        #
        # def _dfs(i, j):
        #     # terminator
        #     if i == len(word1) or j == len(word2):
        #         return (len(word1) - i) or (len(word2) - j)
        #     # check cache
        #     if (i, j) in memo:
        #         return memo[(i, j)]
        #
        #     # process & drill down
        #     if word1[i] == word2[j]:
        #         memo[(i, j)] = _dfs(i + 1, j + 1)
        #     else:
        #         memo[(i, j)] = 1 + min(_dfs(i + 1, j), _dfs(i, j + 1), _dfs(i + 1, j + 1))
        #     # reverse state
        #     return memo[(i, j)]
        #
        # memo = {}
        # ans = _dfs(0, 0)
        # return ans
