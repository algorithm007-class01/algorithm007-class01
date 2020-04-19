# 64. 最小路径和
class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        MAX = float('inf')
        dp = grid
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if i == 0 and j == 0: continue
                x, y = MAX, MAX
                if i > 0: x = grid[i - 1][j] + grid[i][j]
                if j > 0: y = grid[i][j - 1] + grid[i][j]
                dp[i][j] = min(x, y)
        return dp[-1][-1]
