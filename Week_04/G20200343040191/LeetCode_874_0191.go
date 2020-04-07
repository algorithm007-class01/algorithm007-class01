func robotSim(commands []int, obstacles [][]int) int {
    res := 0
    x, y, di := 0, 0, 0
    dx := [4]int{0, 1, 0, -1}
    dy := [4]int{1, 0, -1, 0}
    obsSet := make(map[[2]int]bool)
    for _, o := range obstacles {
        obsSet[[2]int{o[0], o[1]}] = true
    }
    for _, c := range commands {
        if c == -2 {
            di = (di + 3) % 4
        } else if c == -1 {
            di = (di + 1) % 4
        } else {
            for i := 1; i <= c; i++ {
                nx, ny := x + dx[di], y + dy[di]
                if obsSet[[2]int{nx, ny}] {
                    break
                }
                x, y = nx, ny
                res = max(res, x*x + y*y)
            } 
        }
    }
    return res
}

func max(a, b int) int {
    if a >= b {
        return a
    }
    return b
}
