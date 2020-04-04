package G20200343040161

func moveZeroes(nums []int)  {
	if nums == nil || len(nums) <= 1 {
		return
	}

	for i, j := 0, 0; i < len(nums); i++ {
		if nums[i] != 0 {
			if i != j{
				nums[i], nums[j] = nums[j], nums[i]
			}
			j++
		}
	}
}
