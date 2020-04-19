#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/valid-perfect-square/
题目描述
367. Valid Perfect Square
Easy
Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:

Input: 16
Output: true
Example 2:

Input: 14
Output: false
"""

from typing import List


class Solution:
    def isPerfectSquare(self, num: int) -> bool:
        # # 解法1 二分法
        # if num < 0: return False
        # if num == 1: return True
        #
        # i, j = 0, num
        # while i <= j:
        #     mid = (i+j)//2
        #     mul = mid * mid
        #     if mul == num:
        #         return True
        #     elif mul < num:
        #         i = mid + 1
        #     else:
        #         j = mid - 1
        #
        # return False

        # 解法2 牛顿迭代法
        if num < 0: return False
        x = num
        while abs(x * x - num) > 1e-6:
            x = (x + num/x) / 2
            print(x)
        return int(x) ** 2 == num
