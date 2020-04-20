#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/sqrtx/
题目描述
69. Sqrt(x)
Easy
Implement int sqrt(int x).
Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

Example 1:
Input: 4
Output: 2
Example 2:

Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.
"""


class Solution:
    def mySqrt(self, x: int) -> int:
        # # 解法1 二分查找法
        # if x <= 0: return 0
        #
        # i, j = 0, x
        # while i <= j:
        #     mid = (i + j) // 2
        #     mul = mid * mid
        #     if mul == x:
        #         return int(mid)
        #     elif mul < x:
        #         i = mid + 1
        #     else:
        #         j = mid - 1
        # return int(j)

        # 解法2 牛顿迭代法
        # x2 = (x1 + a/x1)/2
        if x <= 0: return 0
        x1 = x
        while True:
            x2 = (x1 + x/x1)/2
            if abs(x1 - x2) < 1e-6:
                break
            x1 = x2
        return int(x1)

        # if x <= 0: return 0
        # pre = 0
        # now = x
        # while abs(now - pre) >= 1:
        #     pre = now
        #     now = (pre + x/pre) / 2
        # return int(now)

        # # 解法2 牛顿迭代法
        # a = x
        # while abs(a * a - x) > 1e-6:
        #     a = (a + x/a)/2
        # return int(a)

        # # 解法2.1 牛顿迭代法 精度控制
        # import decimal
        # from decimal import Decimal
        # decimal.getcontext().prec = 50
        # a = x = Decimal(str(x))
        # while abs(a * a - x) > 1e-48:
        #     a = (a + x/a)/2
        #     print(a)
        # return int(a)
