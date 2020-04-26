# 最大正方形 
# 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
# 状态数组 dp[i][j]表示以第i行，第j列处为右下角的最大正方形的边长，仅当该位置为1时，才有可能存在正方形
# 状态转移数组：
# dp[i][j] = min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1]) + 1
# 若当前位置为1，则此处可以构成最大正方形的边长，是由其左上，正上，右决定的最小值加1
# 初始化状态数组，加1行和1列，以便于下面的计算
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        m = len(matrix)
        n = len(matrix[0])
        res = 0
        if not matrix: return 0
        dp = [[0]*(n+1) for i in range(m+1)] 
        for i in range(1,m+1):
            for j in range(1,n+1):
                # 为什么是matrix[i-1][j-1] == '1'，因为此处的i和j是在dp矩阵中，而dp矩阵比原来多了1行1列，因此判断在当前位置为1，必须回到原来矩阵的行和列中计算，
                if matrix[i-1][j-1] == '1':
                    dp[i][j] = min(dp[i-1][j], dp[i][j-1],dp[i-1][j-1]) + 1
                    res = max(dp[i][j],res)
        return res*res