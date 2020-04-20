class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        def turn0(i: int, j: int):
            if grid[i][j] == '0': return
            grid[i][j] = '0'
            if i - 1 >= 0: turn0(i - 1, j)
            if j - 1 >= 0: turn0(i, j - 1)
            if i + 1 < len(grid): turn0(i + 1, j)
            if j + 1 < len(grid[0]): turn0(i, j + 1)
        count = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == '1':
                    count += 1
                    turn0(i, j)
        return count
