func canJump(nums []int) bool {
    k := 0 
    for i, n := range nums {
        if i > k {
            return false
        }
        k = func(a int, b int) int {
            if a >= b {
                return a 
            }
            return b
        }(k, i + n)
    }
    return true
}
