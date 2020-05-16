#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/longest-palindromic-substring/
题目描述
5. Longest Palindromic Substring
Medium
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
"""


class Solution:
    def longestPalindrome(self, s: str) -> str:
        # # 解法1 中间向两边扩散法
        # if not s: return ''
        #
        # def _longest(i, j):
        #     if i > j: return ''
        #     while i >= 0 and j < len(s):
        #         if s[i] != s[j]: break
        #         i, j = i - 1, j + 1
        #     return s[i+1:j]
        #
        # ans = ''
        # for i in range(len(s)):
        #     for tmp in [_longest(i, i), _longest(i, i + 1)]:  # odd, even
        #         if len(tmp) > len(ans):
        #             ans = tmp
        # return ans

        # 解法2 动态规划
        n = len(s)
        ans = ''
        dp = [[0] * n for _ in range(n)]
        for i in range(n-1, -1, -1):    # todo 注意, 同样是dp, 这里是从“右下”向“左上”方向计算
            for j in range(i, n):
                dp[i][j] = (s[i] == s[j] and (j - i < 2 or dp[i+1][j-1]))

                if dp[i][j] and j - i + 1 > len(ans):
                    ans = s[i:j+1]
        return ans
