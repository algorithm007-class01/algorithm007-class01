#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/climbing-stairs/
题目描述
70. Climbing Stairs
Easy
You are climbing a stair case. It takes n steps to reach to the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
Note: Given n will be a positive integer.
Example 1:
Input: 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps

Example 2:
Input: 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
"""


class Solution:
    def climbStairs(self, n: int) -> int:
        # # 解法1 动态规划, 不进行状态压缩
        # if n < 0: return 0
        # dp = [1] * (n + 1)
        # for i in range(2, n + 1):
        #     dp[i] = dp[i-1] + dp[i-2]
        # return dp[-1]

        # # 解法1 动态递推
        # if n <= 0: return 0
        # a, b = 0, 1
        # for _ in range(n):
        #     a, b = b, a + b
        # return b

        # 解法2 递归+缓存
        def _dfs(n):
            # terminator
            if n < 0: return 0
            if 0 <= n <= 1: return 1
            # check cache
            if n in memo:
                return memo[n]

            # process & drill down
            memo[n] = _dfs(n - 1) + _dfs(n - 2)
            # reverse state
            return memo[n]

        memo = {}
        return _dfs(n)
