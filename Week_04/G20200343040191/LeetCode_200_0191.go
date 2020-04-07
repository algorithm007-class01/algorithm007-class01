func numIslands(grid [][]byte) int {
    nx := len(grid)
    if nx == 0 {
        return 0
    }
    ny := len(grid[0])

    var dfs func([][]byte, int, int)
    dfs = func(grid [][]byte, x, y int) {
        grid[x][y] = 0
        if x - 1 >= 0 && grid[x-1][y] == byte('1') {
            dfs(grid, x - 1, y)
        }
        if y + 1 < ny && grid[x][y+1] == byte('1') {
            dfs(grid, x, y + 1)
        }
        if x + 1 < nx && grid[x+1][y] == byte('1') {
            dfs(grid, x + 1, y)
        }
        if y - 1 >= 0 && grid[x][y-1] == byte('1') {
            dfs(grid, x, y - 1)
        }
    }

    nums := 0
    for i := 0; i < nx; i++ {
        for j := 0; j < ny; j++ {
            if grid[i][j] == byte('1') {
                nums++
                dfs(grid, i, j)
            }
        }
    }
    return nums
}
