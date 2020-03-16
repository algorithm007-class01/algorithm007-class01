func removeDuplicates(nums []int) int {
	if len(nums) == 0 {
		return 0
	}

	i := 0
	for j := 0; j < len(nums); j++ {
		if nums[i] == nums[j] {
            continue
        }
        if j - i > 1 {
            nums[i + 1] = nums[j]
        }
        i++
	}

	return i + 1
}
