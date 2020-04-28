class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if grid is None or len(grid)==0:
            return 0
       
        M, N = len(grid), len(grid[0])

        dx, dy = [-1,0,1,0], [0,1,0,-1]
        count = 0
        for i in range(M):
            for j in range(N):
                if grid[i][j] == "1":
                    count+=1
                    queue = {(i,j)}
                    sign = "%s" % (count+1)
                    while queue:
                        L = len(queue)
                        nq = set()

                        for _ in range(L):
                            curr_i, curr_j = queue.pop()
                            if grid[curr_i][curr_j] == "1":
                                grid[curr_i][curr_j] = sign

                            for d in range(4):
                                n_i, n_j = curr_i+dx[d], curr_j+dy[d]
                                if 0<=n_i<M and 0<=n_j<N and grid[n_i][n_j]=="1":
                                    nq.add((n_i, n_j))

                        queue = nq
        return count