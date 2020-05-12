#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/valid-anagram/
题目描述
242. Valid Anagram
Easy
Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:
Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?
"""

from typing import List


class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        # # 解法1 直接排序
        # return ''.join(sorted(list(s))) == ''.join(sorted(list(t)))

        # 解法2 计数排序
        from collections import defaultdict
        d = defaultdict(int)
        for ch in s: d[ch] += 1
        for ch in t: d[ch] -= 1
        for k, v in d.items():
            if v != 0: return False
        return True
