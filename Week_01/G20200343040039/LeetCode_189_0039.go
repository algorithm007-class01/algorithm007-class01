package G20200343040039

func rotate(nums []int, k int)  {
	k %= len(nums)
	reverse(nums)
	reverse(nums[0:k])
	reverse(nums[k:])
}

// [1,2,3,4,5,6,7]
// [7,6,5,4,3,2,1]
// [7,6,5,1,2,3,4]
// [5,6,7,1,2,3,4]
func reverse(nums []int) {
	i := 0
	j := len(nums)-1
	for i < j {
		nums[i], nums[j] = nums[j], nums[i]
		i++
		j--
	}
}