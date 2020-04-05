package G20200343040161

func twoSum(nums []int, target int) []int {
	if nums == nil || len(nums) == 0 {
		return []int{}
	}

	data := make(map[int]int, 0)
	for i, v := range nums {
		if j, ok := data[target-v]; ok {
			return []int{i, j}
		}
		data[v] =i
	}
	return []int{}
}
