#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

"""
题目描述
20. Valid Parentheses
Easy
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:
Input: "()"
Output: true

Example 2:
Input: "()[]{}"
Output: true

Example 3:
Input: "(]"
Output: false

Example 4:
Input: "([)]"
Output: false

Example 5:
Input: "{[]}"
Output: true
"""


class Solution:
    def isValid(self, s: str) -> bool:
        # # 解法1, 替换法
        # while True:
        #     if '()' in s:
        #         s = s.replace('()', '')
        #     elif '{}' in s:
        #         s = s.replace('{}', '')
        #     elif '[]' in s:
        #         s = s.replace('[]', '')
        #     else:
        #         break
        # return s.strip() == ''

        # 解法2, stack
        s = s.strip()
        from collections import deque
        stack = deque()
        d = {'(': ')', '{': '}', '[': ']'}
        for c in s:
            if c in d:
                stack.append(c)
            elif not stack or d[stack.pop()] != c:
                return False
        return len(stack) == 0
