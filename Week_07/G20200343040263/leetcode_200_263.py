# 岛屿数量
# 广度优先遍历
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        def flood_fill(i,j):
            if grid[i][j] == '1':
                grid[i][j] == '0'
                flood_fill(i-1,j)
                flood_fill(i+1,j)
                flood_fill(i,j-1)
                flood_fill(i,j+1)
        if not grid: return 0
        grid = [['0'] + row + ['0'] for row in grid]
        grid = [[0]* len(grid[0])] + grid + [[0]*len(grid[0])]
        m, n = len(grid), len(grid[0])
        count = 0
        for i in range(1, m-1):
            for j in range(1, n-1):
                if grid[i][j] == '1':
                    count += 1
                flood_fill(i,j)
        return count
# 深度优先遍历
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid: return 0
        row = len(grid)
        col = len(grid[0])
        cnt = 0
        def dfs(i,j):
            grid[i][j] = 0
            for x, y in [[-1,0],[1,0],[0,-1],[0,1]]:
                tmp_i = i + x
                tmp_j = j + x
                if 0 <= tmp_i < row and 0 <= tmp_j < col and grid[i][j] == '1':
                    dfs(temp_i,temp_j)
        for i in range(row):
            for j in range(col):
                if grid[i][j] == '1':
                    dfs(i,j)
                    cnt += 1
        return cnt 