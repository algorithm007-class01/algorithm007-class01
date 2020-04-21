#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/coin-change-2/
题目描述
518. Coin Change 2
Medium

You are given coins of different denominations and a total amount of money.
Write a function to compute the number of combinations that make up that amount.
You may assume that you have infinite number of each kind of coin.
Example 1:

Input: amount = 5, coins = [1, 2, 5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
Example 2:
Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be made up just with coins of 2.
Example 3:
Input: amount = 10, coins = [10]
Output: 1
Note:
You can assume that
0 <= amount <= 5000
1 <= coin <= 5000
the number of coins is less than 500
the answer is guaranteed to fit into signed 32-bit integer
"""

from typing import List


class Solution:
    def change(self, amount: int, coins: List[int]) -> int:

        # # 解法1 DFS+缓存
        # if amount <= 0: return 1
        # if not coins: return 0
        #
        # coins.sort(reverse=True)        # todo reverse=True很重要, 这样才能保证memo有效
        #
        # def _dfs(amount, start):
        #     if amount < 0: return 0
        #     if amount == 0: return 1
        #     if (amount, start) in memo:
        #         return memo[(amount, start)]
        #
        #     cnt = 0
        #     for i in range(start, len(coins)):
        #         cnt += _dfs(amount - coins[i], i)
        #     memo[(amount, start)] = cnt
        #     return cnt
        #
        # memo = {}
        # ans = _dfs(amount, 0)
        # return ans

        # 解法2 动态规划, 完全背包问题, 将硬币看做是商品: 用或者不用, 用的话用几个
        # 和爬楼梯问题很类似, 不过爬楼梯求的是排列数, 本题求的是组合数
        # 爬楼梯: 在外层枚举金额, 在内层枚举硬币
        # 本题: 在外层循环枚举金币, 在内层枚举金额
        if amount <= 0: return 1
        if not coins: return 0
        dp = [1] + [0] * amount
        for coin in coins:                      # 枚举硬币
            if coin > amount: continue
            for i in range(coin, amount+1):     # 枚举金额
                dp[i] += dp[i - coin]
        return dp[-1]
