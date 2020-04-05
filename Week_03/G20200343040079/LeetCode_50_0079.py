#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/powx-n/
题目描述
50. Pow(x, n)
Medium
Implement pow(x, n), which calculates x raised to the power n (xn).

Example 1:
Input: 2.00000, 10
Output: 1024.00000
Example 2:

Input: 2.10000, 3
Output: 9.26100
Example 3:

Input: 2.00000, -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
Note:
-100.0 < x < 100.0
n is a 32-bit signed integer, within the range [−231, 231 − 1]
"""


class Solution:
    def myPow(self, x: float, n: int) -> float:
        # # 解法1 递归
        # if x == 0: return 0
        # if n == 0: return 1
        # if n < 0: return 1 / self.myPow(x, -n)
        # half = self.myPow(x, n // 2)
        # ans = half * half
        # if n & 1: ans *= x
        # return ans

        # 解法2 迭代求解
        if x == 0: return 0
        if n == 0: return 1
        if n < 0: return 1 / self.myPow(x, -n)

        ans = 1
        while n:
            if n & 1: ans *= x
            n >>= 1
            x *= x
        return ans
