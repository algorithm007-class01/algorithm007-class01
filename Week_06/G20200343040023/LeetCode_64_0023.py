# -*- coding: utf-8 -*-


class Solution(object):
    def minPathSum(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """

        raws = len(grid)
        cols = len(grid[0])
        dp = [[0] * cols for _ in range(raws)]
        dp[0][0] = grid[0][0]
        for raw in range(raws):
            for col in range(cols):
                if raw == 0 and col == 0:
                    continue
                if raw == 0:
                    dp[raw][col] = dp[raw][col - 1] + grid[raw][col]
                elif col == 0:
                    dp[raw][col] = dp[raw - 1][col] + grid[raw][col]
                else:
                    dp[raw][col] = min(dp[raw - 1][col],
                                        dp[raw][col - 1]) + grid[raw][col]

        return dp[raws - 1][cols - 1]
