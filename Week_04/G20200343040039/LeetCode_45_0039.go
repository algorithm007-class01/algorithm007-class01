package G20200343040039

func jump(nums []int) int {

	end := 0
	maxPosition := 0
	steps := 0

	for i := 0; i < len(nums) - 1; i++ {
		if maxPosition < nums[i] + i {
			maxPosition = nums[i] + i
		}

		if i == end {
			end = maxPosition
			steps++
		}
	}

	return steps
}