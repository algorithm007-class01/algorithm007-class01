func twoSum(nums []int, target int) []int {
    rMap := make(map[int]int)
    for i, n := range nums {
        if _, ok := rMap[n]; !ok {
            rMap[target - n] = i
        } else {
            return []int{rMap[n], i}
        }
    }
    return []int{}
}
