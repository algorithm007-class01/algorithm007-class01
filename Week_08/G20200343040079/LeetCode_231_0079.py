#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/power-of-two/
题目描述
231. Power of Two
Easy
Given an integer, write a function to determine if it is a power of two.

Example 1:

Input: 1
Output: true
Explanation: 20 = 1
Example 2:

Input: 16
Output: true
Explanation: 24 = 16
Example 3:

Input: 218
Output: false
"""

from typing import List


class Solution:
    def isPowerOfTwo(self, n: int) -> bool:
        # return (n > 0) and bin(n).count('1') == 1

        if n <= 0: return False
        if n == 1: return True
        while n != 1:
            if n & 1: return False
            n = n >> 1
        return True
