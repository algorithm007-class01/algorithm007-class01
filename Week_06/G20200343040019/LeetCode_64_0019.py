class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        if not grid or not grid[0]:
            return 0
        m = len(grid)
        n = len(grid[0])
        dp = [[0 for _ in range(n)] for _ in range(m)]

        for i in range(m):
            for j in range(n):
                if i==0 and j == 0:
                    dp[i][j] = grid[i][j]
                    continue
                if i==0:
                    dp[i][j] = dp[i][j-1] + grid[i][j]
                    continue
                if j==0:
                    dp[i][j] = dp[i-1][j] +grid[i][j]
                    continue
                dp[i][j] = min(dp[i-1][j], dp[i][j-1] ) + grid[i][j]
        # print(dp)
        return dp[m-1][n-1]