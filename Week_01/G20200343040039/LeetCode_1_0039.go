package G20200343040039

func twoSum(nums []int, target int) []int {
	cacheMap := make(map[int]int)

	for i := 0; i < len(nums); i++ {
		temp := target - nums[i]
		if j, ok := cacheMap[temp]; ok {
			return []int{i, j}
		}
		cacheMap[nums[i]] = i
	}

	return nil
}