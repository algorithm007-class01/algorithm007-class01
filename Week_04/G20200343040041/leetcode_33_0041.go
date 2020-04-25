package G20200343040041

func search(nums []int, target int) int {
	lo, hi := 0, len(nums)-1
	for lo <= hi {
		mid := lo + (hi-lo)>>1
		if nums[mid] == target {
			return mid
		}
		if nums[0] <= nums[mid] && (nums[0] > target || nums[mid] < target) {
			lo = mid + 1
		} else if nums[0] > nums[mid] && (nums[mid] < target && nums[0] > target) {
			lo = mid + 1
		} else {
			hi = mid - 1
		}
	}
	return -1
}
