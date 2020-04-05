func combine(n int, k int) [][]int {
    res := make([][]int, 0)
    var backTrace func(int, []int)
    backTrace = func(first int, cur []int) {
        if len(cur) == k {
            c := make([]int, len(cur))
            copy(c, cur)
            res = append(res, c)
            return
        }
        for i := first; i <= n; i++ {
            cur = append(cur, i)
            backTrace(i+1, cur)
            cur = cur[:len(cur)-1]
        }
    }
    backTrace(1, []int{})
    return res
}
