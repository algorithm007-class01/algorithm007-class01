func permute(nums []int) [][]int {
    res := make([][]int, 0)
    var backTrace func([]int)
    backTrace = func(cur []int) {
        if len(cur) == len(nums) {
            c := make([]int, len(cur))
            copy(c, cur)
            res = append(res, c)
            return
        }
        for _, n := range nums {
            if contain(cur, n) {
                continue
            }
            cur = append(cur, n)
            backTrace(cur)
            cur = cur[:len(cur)-1]
        }
    }
    backTrace([]int{})
    return res
}

func contain(sl []int, n int) bool {
    for _, s := range sl {
        if s == n {
            return true
        }
    }
    return false
}
