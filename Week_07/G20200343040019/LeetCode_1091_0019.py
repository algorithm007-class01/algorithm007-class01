from queue import PriorityQueue

class Solution:
    def shortestPathBinaryMatrix(self, grid: List[List[int]]) -> int:
        # to do: 最短路径A* 算法  
        if not grid or not grid[0]:
            return -1
        if grid[0][0]!=0 or grid[-1][-1]!=0:
            return -1
        def heuristic(x, y):
            return max(abs(n-1 - x), abs(n-1 - y))
        # queue = PriorityQueue()
        # queue.put((0,0))
        queue = [(0,0)]
        n,m = len(grid),len(grid[0])
        visited = [[0 for _ in range(m)] for _ in range(n)]
        visited[0][0]=1
        step = 0
        while queue:
            L = len(queue)
            step+=1
            for _ in range(L):
                i,j = queue.pop(0)
                if i==n-1 and j==m-1:
                    return step
                for ni,nj in ((i-1,j),(i-1,j-1),(i-1,j+1),(i,j-1),(i,j+1),(i+1,j-1),(i+1,j),(i+1,j+1)):
                    if 0<=ni<len(grid) and 0<=nj<len(grid[0]) and grid[ni][nj]==0 and visited[ni][nj]==0 :              
                        visited[ni][nj]=1
                        if ni==n-1 and nj==m-1:
                            return step+1
                        queue.append((ni,nj))
        return -1

                    
                