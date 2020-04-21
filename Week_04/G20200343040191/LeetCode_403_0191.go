func canCross(stones []int) bool {
    dpMap := make(map[int]map[int]struct{})
    for _, s := range stones {
        dpMap[s] = make(map[int]struct{})
    }
    dpMap[0][0] = struct{}{}
    for _, s := range stones {
        for k := range dpMap[s] {
            for step := k - 1; step <= k + 1; step++ {
                if dpMap[s + step] != nil {
                    dpMap[s + step][step] = struct{}{}
                }
            }
        }
    }
    if len(dpMap[stones[len(stones)-1]]) == 0 {
        return false
    }
    return true
}
