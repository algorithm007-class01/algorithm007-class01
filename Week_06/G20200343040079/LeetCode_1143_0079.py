#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/longest-common-subsequence/
题目描述
1143. Longest Common Subsequence
Medium
Given two strings text1 and text2, return the length of their longest common subsequence.

A subsequence of a string is a new string generated from the original string with
some characters(can be none) deleted without changing the relative order of the remaining characters.
(eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings is
a subsequence that is common to both strings.

If there is no common subsequence, return 0.
Example 1:
Input: text1 = "abcde", text2 = "ace"
Output: 3
Explanation: The longest common subsequence is "ace" and its length is 3.
Example 2:
Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
Example 3:
Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.

Constraints:
1 <= text1.length <= 1000
1 <= text2.length <= 1000
The input strings consist of lowercase English characters only.
"""


class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        # # 解法1 回溯+缓存
        # if not text1 or not text2: return 0
        #
        # def _dfs(i, j):
        #     # terminator
        #     if i == l1 or j == l2:
        #         return 0
        #     # check cache
        #     if (i, j) in memo: return memo[(i, j)]
        #     # process & drill down
        #     memo[(i, j)] = (1 + _dfs(i + 1, j + 1)) if text1[i] == text2[j] else max(_dfs(i + 1, j), _dfs(i, j + 1))
        #     return memo[(i, j)]
        #
        # l1, l2 = len(text1), len(text2)
        # memo = {}
        # ans = _dfs(0, 0)
        # return ans

        # 解法2 动态规划
        if not text1 or not text2: return 0
        rows = len(text1) + 1
        cols = len(text2) + 1
        dp = [[0] * cols for _ in range(rows)]
        for i in range(1, rows):
            for j in range(1, cols):
                if text1[i-1] == text2[j-1]:
                    dp[i][j] = dp[i-1][j-1] + 1
                else:
                    dp[i][j] = max(dp[i-1][j-1], dp[i][j-1], dp[i-1][j])
        return dp[-1][-1]


res = Solution().longestCommonSubsequence("ylqpejqbalahwr", "yrkzavgdmdgtqpg")
print(res)
