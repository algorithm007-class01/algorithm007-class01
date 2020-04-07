class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        count = 0
        n = len(grid)
        if n == 0: return 0
        m = len(grid[0])
        if m == 0: return 0
        flag = [[0 for i in range(m)] for i in range(n)]
        print(flag)

        def dfs(x, y):
            flag[x][y] = 1
            dx = [1, 0, -1, 0]
            dy = [0, 1, 0, -1]
            for i in range(4):
                nx = dx[i] + x
                ny = dy[i] + y
                if 0 <= nx < n and 0 <= ny < m and grid[nx][ny] == '1' and flag[nx][ny] == 0:
                    dfs(nx, ny)

        for i in range(n):
            for j in range(m):
                if grid[i][j] == '1' and flag[i][j] == 0:
                    dfs(i, j)
                    count += 1
        return count
