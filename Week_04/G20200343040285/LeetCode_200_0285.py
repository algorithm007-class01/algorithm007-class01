class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        m = len(grid) 
        if not m:return 0
        n = len(grid[0])
        res = 0
        self.dx = (-1,1,0,0)
        self.dy = (0,0,-1,1)
        mark = [[0 for _ in range(n)] for _ in range(m)]
        
        for i in range(m):
            for j in range(n):
                if not mark[i][j] and grid[i][j] == "1":
                    # self._dfs(mark, grid, i, j, m, n)
                    
                    self._bfs(mark, grid, i, j, m, n)
                    res += 1 
        return res

    def _bfs(self, mark, grid, x, y, m, n):
        q = deque([(x, y)])
        mark[x][y] = 1
        while q:
            curx, cury = q.popleft()
            if mark[x][y] == 0:
                mark[x][y] = 1 
            for i in range(4):
                newx = self.dx[i] + curx 
                newy = self.dy[i] + cury
                if 0 <= newx < m and 0 <= newy < n and not mark[newx][newy] and grid[newx][newy] == '1':
                    q.append((newx, newy))
                    mark[newx][newy] = 1
            


    def _dfs(self, mark, grid, x, y, m, n):
        mark[x][y] = 1
        for i in range(4):
            newx = self.dx[i] + x 
            newy = self.dy[i] + y
            if 0 <= newx < m or 0 <= newy < n and mark[newx][newy] == 1 and grid[newx][newy] == '1':
                self._dfs(mark, grid, newx, newy, m, n)


input = [["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]
res = Solution().numIslands(input)