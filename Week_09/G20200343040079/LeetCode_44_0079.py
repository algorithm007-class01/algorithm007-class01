#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/wildcard-matching/
题目描述
44. Wildcard Matching
Hard
Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like ? or *.
Example 1:

Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input:
s = "aa"
p = "*"
Output: true
Explanation: '*' matches any sequence.
Example 3:

Input:
s = "cb"
p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
Example 4:

Input:
s = "adceb"
p = "*a*b"
Output: true
Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
Example 5:

Input:
s = "acdcb"
p = "a*c?b"
Output: false
"""


class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        # 解法1 匹配 + 记忆化缓存
        def _is_match(i, j):
            # terminator
            if j == len(p): return i == len(s)
            if i == len(s):
                while j < len(p):
                    if p[j] != '*': return False
                    j += 1
                return True
            # check cache
            if (i, j) in memo:
                return memo[(i, j)]

            # process & drill down
            if p[j] == '*':
                memo[(i, j)] = _is_match(i, j + 1) or _is_match(i + 1, j)
                return memo[(i, j)]

            first_match = i < len(s) and p[j] in {s[i], '?'}
            memo[(i, j)] = first_match and _is_match(i + 1, j + 1)
            return memo[(i, j)]

        memo = {}
        return _is_match(0, 0)


print(Solution().isMatch(
    "aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba",
    "a*******b"
))
