package G20200343040161

func findMin(nums []int) int {
	if nums == nil {
		return 0
	}
	n := len(nums)
	if n == 1{
		return nums[0]
	}

	start := 0
	end := n-1
	mid := 0
	if nums[start]<nums[end] {
		return nums[0]
	}
	first := nums[0]
	for start<=end {
		mid = start + (end-start)/2
		if nums[mid]>nums[mid+1] {
			return nums[mid+1]
		}

		if nums[mid] >= first {
			start = mid+1
		} else {
			end = mid-1
		}
	}
	return 0
}