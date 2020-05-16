#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/unique-paths/
题目描述
62. Unique Paths
Medium
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
The robot can only move either down or right at any point in time. The robot is trying to
reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?
Above is a 7 x 3 grid. How many possible unique paths are there?

Example 1:
Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Right -> Down
2. Right -> Down -> Right
3. Down -> Right -> Right
Example 2:
Input: m = 7, n = 3
Output: 28
Constraints:
1 <= m, n <= 100
It's guaranteed that the answer will be less than or equal to 2 * 10 ^ 9.
"""


class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        # 解法1 动态规划
        # if m <= 0 or n <= 0: return 0
        # dp = [[1] * m for _ in range(n)]
        # for i in range(1, n):
        #     for j in range(1, m):
        #         dp[i][j] = dp[i-1][j] + dp[i][j-1]
        # return dp[-1][-1]

        # # 解法1.1 动态规划, 将大问题化解为子问题、子子问题, 寻找大问题和子问题之间可以递推的公式
        # # 然后根据子问题的直观解逐步推导大问题的解
        # if m <= 0 or n <= 0: return 0
        # dp = [1] * m              # 状态压缩, 节省空间
        # for i in range(1, n):
        #     for j in range(1, m):
        #         dp[j] = dp[j] + dp[j - 1]
        # return dp[-1]

        # # 解法2 递归 + 记忆缓存
        # if m <= 0 or n <= 0: return 0
        #
        # def _traverse(i, j):
        #     if i == n - 1 or j == m - 1: return 1
        #     if (i, j) in memo: return memo[(i, j)]
        #     memo[(i, j)] = _traverse(i + 1, j) + _traverse(i, j + 1)
        #     return memo[(i, j)]
        #
        # memo = {}
        # ans = _traverse(0, 0)
        # return ans

        # 解法2.1 递归 + 记忆缓存
        if m <= 1 or n <= 1: return 1

        def _dfs(m, n):
            # terminator
            if m < 1 or n < 1: return 0
            if m == 1 or n == 1: return 1   # todo 注意m, n的取值和对应网格关系
            # check cache
            if (m, n) in memo:
                return memo[(m, n)]
            # process & drill down
            memo[(m, n)] = _dfs(m - 1, n) + _dfs(m, n - 1)
            # reverse state
            return memo[(m, n)]

        memo = {}
        ans = _dfs(m, n)
        return ans


print(Solution().uniquePaths(3, 2))
print(Solution().uniquePaths(7, 3))
