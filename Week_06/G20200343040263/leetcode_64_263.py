# 最小路径和
# 状态数组dp=grid,直接在grid上进行操作，
# 状态转移方程： grid[x][y]+=min(grid[x−1][y],grid[x][y−1])
# 初始化边界条件： 第一行的边界路径是，前面的所有格子依次相加；第一列的边界路径，前面列的格子依次相加
class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        if not gird: return 0
        m = len(grid)
        n = len(grid[0])
        for i in range(1,n):
            gird[0][i] += grid[0][i-1]
        for j in range(1,m):
            grid[j][0] += grid[j-1][0]
        for i in range(1,m):
            for j in range(1,n):
                grid[i][j] += min(grid[i-1][j],grid[i][j-1])
        return grid[-1][-1] 