#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/coin-change/
题目描述
322. Coin Change
Medium
You are given coins of different denominations and a total amount of money amount.
Write a function to compute the fewest number of coins that you need to make up that amount.
If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:
Input: coins = [1, 2, 5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Note:
You may assume that you have an infinite number of each kind of coin.
"""

from typing import List


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        # # 解法1 动态递推
        # # todo 关注 -1 和 0 的含义
        # # -1 表示不可达, v>=0表示v枚硬币
        # # dp[i]状态方程是自顶向下分析，求解是自底向上
        # if amount < 0: return -1
        # dp = [0] + [-1] * amount
        # for i in range(1, len(dp)):
        #     charge = [dp[i-c] for c in coins if i >= c and dp[i-c] != -1]
        #     dp[i] = (min(charge) + 1) if charge else -1
        # return dp[-1]

        # # 解法2 递归+缓存, 递归回溯, 暴力求解, 包含重复子问题, 因此可以用暴力+缓存
        # if not coins: return -1
        #
        # def _dfs(amount):
        #     if amount == 0: return 0
        #     if amount < 0: return -1
        #     if amount in memo: return memo[amount]
        #
        #     counts = [_dfs(amount - c) for c in coins]
        #     counts = [v for v in counts if v != -1]
        #     memo[amount] = (min(counts) + 1) if counts else -1
        #     return memo[amount]
        #
        # memo = {}
        # return _dfs(amount)

        # 解法3: 广度优先遍历BFS
        if amount < 0: return -1
        from collections import deque
        q = deque([(0, 0)])
        visited = set()
        while q:
            total, cnt = q.popleft()
            if total == amount: return cnt
            if total < amount:
                cnt += 1
                for c in coins:
                    t = total + c
                    if t in visited: continue   # 访问过的不再访问
                    visited.add(t)
                    q.append((t, cnt))
        return -1

        # # 解法3.1 BFS遍历
        # if not coins: return -1
        #
        # from collections import deque
        # q = deque([amount])
        # level = 0
        # visited = set()
        # while q:
        #     for _ in range(len(q)):
        #         remain = q.popleft()
        #         if remain == 0: return level
        #         for c in coins:
        #             t = remain - c
        #             if remain >= c and t not in visited:
        #                 visited.add(t)
        #                 q.append(t)
        #     level += 1
        # return -1


res = Solution().coinChange([1, 2, 5], 11)
print(res)

res = Solution().coinChange([2], 3)
print(res)

res = Solution().coinChange([1, 2, 5], 100)
print(res)
