package G20200343040039

func permute(nums []int) [][]int {
	result := make([][]int, 0)
	used := make(map[int]struct{}, len(nums))

	subResult := make([]int, 0, len(nums))

	back_track(nums, subResult, used, &result)

	return result
}

func back_track(nums []int, subResult []int,used map[int]struct{}, result *[][]int) {
	if len(subResult) == len(nums) {
		newSubResult := make([]int, len(subResult))
		copy(newSubResult, subResult)

		*result = append(*result, newSubResult)
	}

	for i := 0; i < len(nums); i++ {
		if _, ok := used[nums[i]]; ok {
			continue
		}

		subResult = append(subResult, nums[i])
		used[nums[i]] = struct{}{}
		back_track(nums, subResult, used, result)
		subResult = subResult[:len(subResult) - 1]
		delete(used, nums[i])
	}
}