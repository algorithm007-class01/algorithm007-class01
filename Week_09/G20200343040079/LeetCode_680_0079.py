#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/valid-palindrome-ii/
题目描述
680. Valid Palindrome II
Easy
Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

Example 1:
Input: "aba"
Output: True
Example 2:
Input: "abca"
Output: True
Explanation: You could delete the character 'c'.
Note:
The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
"""


class Solution:
    def validPalindrome(self, s: str) -> bool:
        if not s: return True

        def _is_valid(i, j):
            if i >= j: return True
            while i < j:
                if s[i] != s[j]: return False
                i, j = i + 1, j - 1
            return True

        i, j = 0, len(s) - 1
        while i < j:
            if s[i] == s[j]:
                i, j = i + 1, j - 1
            else:
                return _is_valid(i + 1, j) or _is_valid(i, j - 1)
        return True
