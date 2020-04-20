func surfaceArea(grid [][]int) int {
    dr := []int{0, 1, 0, -1}
    dc := []int{1, 0, -1, 0}

    size := len(grid)
    ans := 0
    
    for r := 0; r < size; r++ {
        for c :=0; c < size; c++ {
            if grid[r][c] <= 0 {
                continue
            }
            ans += 2
            for k := 0; k < 4; k++ {
                nr := r + dr[k]
                nc := c + dc[k]
                nv := 0
                if 0 <= nr && nr < size && 0 <= nc && nc < size {
                    nv = grid[nr][nc]
                }

                if grid[r][c] > nv  {
                    ans += grid[r][c] - nv
                }
            }
        }
    }

    return ans
}