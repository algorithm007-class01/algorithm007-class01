class Solution:
    def dfs(self, arr, x,y):
        
        arr[x][y] = '0'
        if x - 1 >= 0 and arr[x-1][y] is '1':
            self.dfs(arr, x-1, y)
        if x + 1 < len(arr) and arr[x+1][y] is '1':
            self.dfs(arr, x+1, y)
        
        if y - 1 >= 0 and arr[x][y-1] is '1':
            self.dfs(arr, x, y-1)
        if y + 1 < len(arr[0]) and arr[x][y+1] is '1':
            self.dfs(arr, x, y+1 )
        
        return None

    def numIslands(self, grid: List[List[str]]) -> int:

        islandsNum  = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] is '1':
                    islandsNum += 1                 
                    self.dfs(grid, i,j)
        return islandsNum

        
 