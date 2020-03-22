package G20200343040161

func rotate(nums []int, k int)  {
	if nums == nil || len(nums) <= 1 || k == 0{
		return
	}

	n := len(nums)
	k = k%n
	reverse(0, n-1, nums)
	reverse(0, k-1, nums)
	reverse(k, n-1, nums)
}

func reverse(start, end int, nums []int) {
	for start < end {
		nums[start], nums[end] = nums[end], nums[start]
		start++
		end--
	}
}