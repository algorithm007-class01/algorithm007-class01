package G20200343040161

func twoSum(nums []int, target int) []int {
	if nums == nil || len(nums) == 0 {
		return []int{}
	}

	data := make(map[int]int, 0)
	for i, v := range nums {
		if x, ok := data[target-v]; ok {
			return []int{i, x}
		} else {
			data[v] = i
		}
	}
	return []int{}
}
