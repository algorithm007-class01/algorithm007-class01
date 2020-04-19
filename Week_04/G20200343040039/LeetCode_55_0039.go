package G20200343040039

func canJump(nums []int) bool {

	return canJumpFromPosition(0, nums)
}

func canJumpFromPosition(position int, nums []int) bool {
	if position == len(nums) -1 {
		return true
	}

	furthestJump := int(math.Min(float64(position + nums[position]), float64(len(nums)-1)))

	for nextPosition := position + 1; nextPosition <= furthestJump; nextPosition++ {
		if canJumpFromPosition(nextPosition, nums) {
			return true
		}
	}

	return false
}