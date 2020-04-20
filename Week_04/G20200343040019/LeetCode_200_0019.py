class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if grid is None or len(grid)==0:
            return 0
        
        m, n = len(grid), len(grid[0])
        def findisland(m,n):
            
            return None
      
        def BFSremove(island):
            queue = [island]
            while queue:
                i,j = queue.pop(0)
                if i<0 or j<0 or i>=m or j>=n:
                    continue
                if grid[i][j] == "1":
                    grid[i][j] = "0"
                    queue.append((i, j-1))
                    queue.append((i+1, j))
                    queue.append((i, j+1))
                    queue.append((i-1, j))

        res = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == "1":
                    res+=1
                    BFSremove([i,j])

        return res