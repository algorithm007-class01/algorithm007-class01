#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/longest-valid-parentheses/
题目描述
32. Longest Valid Parentheses
Hard
Given a string containing just the characters '(' and ')', find the length of
the longest valid (well-formed) parentheses substring.

Example 1:

Input: "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()"
Example 2:
Input: ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()"
"""

from typing import List


class Solution:
    def longestValidParentheses(self, s: str) -> int:
        # 解法1 动态规划
        if not s: return 0
        dp = [0] * len(s)

        for i in range(1, len(s)):
            if s[i] == ')':
                if s[i - 1] == '(':
                    dp[i] = 2 + (dp[i - 2] if i >= 2 else 0)
                elif i - dp[i - 1] > 0 and s[i - dp[i - 1] - 1] == '(':
                    dp[i] = 2 + dp[i - 1] + (dp[i - dp[i - 1] - 2] if (i - dp[i - 1] >= 2) else 0)
        return max(dp)

        # # 解法2 栈
        # if not s: return 0
        #
        # ans = 0
        # stack = []
        # for i, ch in enumerate(s):
        #     if ch == '(' or not stack:
        #         stack.append(i)
        #     else:
        #         if s[stack[-1]] == '(':
        #             stack.pop()
        #             ans = max(ans, (i - stack[-1]) if stack else (i + 1))
        #         else:
        #             stack.append(i)
        # return ans


print(Solution().longestValidParentheses(
    "(()"
))
