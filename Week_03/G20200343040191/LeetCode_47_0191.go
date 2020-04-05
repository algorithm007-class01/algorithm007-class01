func permuteUnique(nums []int) [][]int {
    res := make([][]int, 0)
    sort.Ints(nums)
    var backTrace func([]int, []bool)
    backTrace = func(cur []int, used []bool) {
        if len(cur) == len(nums) {
            c := make([]int, len(cur))
            copy(c, cur)
            res = append(res, c)
            return 
        }
        for i, n := range nums {
            if used[i] || i > 0 && n == nums[i - 1] && !used[i - 1] {
                continue
            }
            used[i] = true
            cur = append(cur, n)
            backTrace(cur, used)
            cur = cur[:len(cur)-1]
            used[i] = false
        }
    }
    backTrace([]int{}, make([]bool, len(nums)))
    return res
}
