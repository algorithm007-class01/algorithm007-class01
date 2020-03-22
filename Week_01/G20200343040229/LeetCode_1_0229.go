func twoSum(nums []int, target int) []int {
	m := map[int]int{}
	for i, v := range nums {
		if k, ok := m[target-v]; ok {
			return []int{k, i}
		}
		m[v] = i
	}
	return nil
}

// 暴力解法
func twoSum1(nums []int, target int) []int {
    size := len(nums)
    var result []int
    for i := 0; i < size - 1; i++ {
        for j := i + 1; j < size; j++ {
            if nums[i] + nums[j] == target {
                result = []int{i, j}
                break
            }
        }
    }

    return result
}
