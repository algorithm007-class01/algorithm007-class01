package G20200343040039

func findMin(nums []int) int {

	left := 0
	right := len(nums) - 1

	for left < right {
		mid := left + (right - left) / 2
		if nums[mid] > nums[right] {
			left = mid + 1
		} else {
			right = mid
		}
	}

	return nums[left]
}