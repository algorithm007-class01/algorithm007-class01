func minPathSum(grid [][]int) int {
    gridLength := len(grid)
    subGridLenth := len(grid[0])
    for i := 0; i < gridLength; i++ {
        for j := 0; j < subGridLenth; j++ {
            if i == j && i == 0 {
                continue
            } else if i == 0 {
                grid[i][j] = grid[i][j] + grid[i][j-1]
            } else if j == 0 {
                grid[i][j] = grid[i][j] + grid[i-1][j]
            } else {
                grid[i][j] = grid[i][j] + min(grid[i-1][j], grid[i][j-1])
            }
        }
    }
    return grid[gridLength-1][subGridLenth-1]
}

func min(x, y int) int {
    if x > y {
        return y
    }
    return x
}
