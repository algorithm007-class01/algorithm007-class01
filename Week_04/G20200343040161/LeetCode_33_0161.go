package G20200343040161

func search(nums []int, target int) int {
	n := len(nums)
	if n == 0 {
		return -1
	}
	if n == 1 {
		if nums[0] == target {
			return 0
		} else {
			return -1
		}
	}
	start := 0
	end := n - 1
	mid := 0
	for start <= end {
		mid = start + (end - start)/2
		if nums[mid] == target {
			return mid
		}
		if nums[mid] > nums[start] {
			if nums[start] == target {
				return start
			}
			if nums[mid]>target && target>nums[start] {
				end = mid-1
			} else {
				start = mid+1
			}
		} else {
			if nums[end] == target {
				return end
			}
			if nums[end]>target && target>nums[mid] {
				start = mid+1
			} else {
				end = mid-1
			}
		}
	}

	return -1
}