from typing import List

class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        i,j = 0,0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if i == 0 and j == 0:
                    continue
                elif i == 0:
                    grid[i][j] = grid[i][j - 1] + grid[i][j]
                elif j == 0:
                    grid[i][j] = grid[i - 1][j] + grid[i][j]
                else:
                    #任意一格等于其本身数值，加上左边或者上面一格的最小值
                    grid[i][j] = min(grid[i][j - 1],grid[i - 1][j]) + grid[i][j]
        return grid[-1][-1]
##################################代码调用###############################
grid = [[1,3,1],
  [1,5,1],
  [4,2,1]]

res = Solution().minPathSum(grid)
print(res)