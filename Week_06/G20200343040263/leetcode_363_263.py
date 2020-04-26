class Solution:
    def maxSumSubmatrix(self, matrix: List[List[int]], k: int) -> int:
        rows = len(matrix)
        cols = len(matrix)
        max1 = 0
        dp = [[0]*cols for i in range(rows)]
        for i in range(1,rows):
            for j in range(1,cols):
                dp[i][j] = matrix[i-1][j-1]
                for i1 in range(i,rows+1):
                    for j1 in range(i,cols+1):
                        dp[i1][j1] = dp[i1-1][j1]+dp[i1][j1-1]-dp[i1-1][j1-1]+matrix[i1-1][j1-1]
                        if dp[i1][j1] <= k:
                            max1 = max(max1,dp[i1][j1])
        return max1