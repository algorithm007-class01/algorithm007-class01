package G20200343040041

func findMin(nums []int) int {
	lo, hi := 0, len(nums)-1
	if nums[0] <= nums[hi] {
		return nums[0]
	}

	for lo < hi {
		mid := lo + (hi-lo)>>1
		if nums[mid] < nums[hi] {
			hi = mid
		} else if nums[mid] > nums[hi] {
			lo = mid + 1
		}
	}
	return nums[lo]
}
