package G20200343030495

func moveZeroes(nums []int)  {
	length := len(nums)
	noZeroIndex := 0
	for currnet := 0; currnet < length; currnet++ {
		if nums[currnet] != 0 {
			nums[noZeroIndex], nums[currnet] = nums[currnet], nums[noZeroIndex]
			noZeroIndex++
		}

	}
}