#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/palindromic-substrings/
题目描述
647. Palindromic Substrings
Medium

Given a string, your task is to count how many palindromic substrings in this string.
The substrings with different start indexes or end indexes are counted as different substrings
even they consist of same characters.

Example 1:
Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
Example 2:
Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
Note:
The input string length won't exceed 1000.
"""

from typing import List


class Solution:
    def countSubstrings(self, s: str) -> int:
        # # 解法1 暴力求解, 超时TLE
        # if not s: return 0
        #
        # def _check_palindrom(i, j):
        #     if i >= j: return True
        #     while i < j:
        #         if s[i] != s[j]: return False
        #         i += 1
        #         j -= 1
        #     return True
        #
        # ans = 0
        # for i in range(len(s)):
        #     for j in range(i, len(s)):
        #         if _check_palindrom(i, j):
        #             ans += 1
        # return ans

        # 解法2 从可能的回文串中心查找
        if not s: return 0

        ans = 0
        for i in range(len(s)):
            for l, r in [(i, i), (i, i + 1)]:
                while l >= 0 and r < len(s) and s[l] == s[r]:
                    ans += 1
                    l -= 1
                    r += 1
        return ans

        # 解法3 todo 马拉车算法


print(Solution().countSubstrings("abc"))
