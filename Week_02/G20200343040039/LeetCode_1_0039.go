package G20200343040039


func twoSum(nums []int, target int) []int {
	cacheMap := make(map[int]int)

	for i := 0; i < len(nums); i++ {
		item := target - nums[i]
		if index, ok := cacheMap[item]; ok {
			return []int{index, i}
		}
		cacheMap[nums[i]] = i
	}

	return nil
}

