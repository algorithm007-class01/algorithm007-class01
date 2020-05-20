#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/
题目描述
面试题47. 礼物的最大价值
在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，
并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
示例 1:
输入:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 12
解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物

提示：
0 < grid.length <= 200
0 < grid[0].length <= 200
"""

from typing import List


class Solution:
    def maxValue(self, grid: List[List[int]]) -> int:
        # 解法1 动态规划
        # 分析: 将大问题化解为子问题, 寻找大问题和子问题、子子问题的关系式
        # 再由最小问题的直观解推导大问题的解
        if not grid or not grid[0]: return 0
        rows, cols = len(grid), len(grid[0])
        dp = grid[0][:]
        for j in range(1, cols):
            dp[j] += dp[j - 1]
        for i in range(1, rows):
            for j in range(cols):
                dp[j] = grid[i][j] + max(dp[j], dp[j - 1] if j > 0 else 0)
        return dp[-1]


res = Solution().maxValue([
    [1, 3, 1],
    [1, 5, 1],
    [4, 2, 1]
])
print(res)
