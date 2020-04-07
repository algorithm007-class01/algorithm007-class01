func jump(nums []int) int {
    res := 0 
    end := 0
    maxPos := 0 
    for i := 0; i < len(nums)-1; i++ {
        maxPos = max(maxPos, i + nums[i])
        if i >= end {
            end = maxPos
            res++
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
