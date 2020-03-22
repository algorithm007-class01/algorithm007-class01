func twoSum(nums []int, target int) []int {
    recMap := make(map[int]int)
    for i, n := range nums {
        if _, ok := recMap[n]; ok {
            return []int{recMap[n], i}
        }
        recMap[target - n] = i
    }
    return []int{}
}
