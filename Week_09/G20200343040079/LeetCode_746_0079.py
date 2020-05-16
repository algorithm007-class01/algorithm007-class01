#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/min-cost-climbing-stairs/
题目描述
746. Min Cost Climbing Stairs
Easy
On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
Once you pay the cost, you can either climb one or two steps. You need to find minimum cost
to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.

Example 1:
Input: cost = [10, 15, 20]
Output: 15
Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
Example 2:
Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
Output: 6
Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
Note:
cost will have a length in the range [2, 1000].
Every cost[i] will be an integer in the range [0, 999].
"""

from typing import List


class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        # 解法1 动态规划
        # 状态定义 + 转移方程 + 初始状态: 开始递推
        if not cost: return 0
        if len(cost) <= 2: return min(cost)

        dp = cost[:] + [0]
        for i in range(2, len(dp)):
            dp[i] += min(dp[i-1], dp[i-2])
        return dp[-1]

        # # 不加哨兵
        # if not cost: return 0
        # if len(cost) <= 2: return min(cost)
        # dp = cost[:]
        # for i in range(2, len(dp)):
        #     dp[i] += min(dp[i - 1], dp[i - 2])
        # return min(dp[-2:])
