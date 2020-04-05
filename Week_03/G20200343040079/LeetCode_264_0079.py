#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/ugly-number-ii/
题目描述
264. Ugly Number II
Medium
Write a program to find the n-th ugly number.
Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.

Example:
Input: n = 10
Output: 12
Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
Note:
1 is typically treated as an ugly number.
n does not exceed 1690.
"""


class Solution:
    def nthUglyNumber(self, n: int) -> int:
        # # 解法1 用堆实现
        # if n < 1: return 0
        # import heapq
        # heap = [1]
        # s = {1}
        # for i in range(n):
        #     mmin = heapq.heappop(heap)
        #     for prime in (2, 3, 5):
        #         mul = mmin * prime
        #         if mul not in s:
        #             s.add(mul)
        #             heapq.heappush(heap, mul)
        # return mmin

        # 解法2 动态规划, 用三个指针
        if n < 1: return 0
        dp = [1] * (n + 1)
        j2 = j3 = j5 = 1
        for i in range(2, n + 1):
            v2, v3, v5 = dp[j2] * 2, dp[j3] * 3, dp[j5] * 5
            dp[i] = min(v2, v3, v5)
            if v2 == dp[i]: j2 += 1
            if v3 == dp[i]: j3 += 1
            if v5 == dp[i]: j5 += 1
        return dp[-1]
