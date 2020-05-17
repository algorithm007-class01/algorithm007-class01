package G20200343040039

func lengthOfLIS(nums []int) int {
	dpLen := 1
	numsLen := len(nums)
	if numsLen == 0 {
		return 0
	}
	dp := make([]int, numsLen + 1)

	dp[dpLen] = nums[0] //用来保存升序数组，这个数组始终为最长上升子序列，如果新的值，比最后一个值大，那么直接增加长度，
	//如果比最后一个小，那么更新，也不会影响最大长度，直到找到更大的值，或者更长的升序序列

	for i := 1; i < numsLen; i++ {
		if nums[i] > dp[dpLen] { //如果比dp的最后一个元素大，那么dpLen + 1， 更新dp的最后一个元素
			dpLen += 1
			dp[dpLen] = nums[i]
		} else {  //如果比dp的最后一个元素小，找到比这个元素大的最小值，替换为该值，更新dp
			left := 1
			right := dpLen  //4
			pos := 0
			for left <= right {
				mid := (left + right) >> 1 // 3
				if dp[mid] < nums[i] {
					pos = mid  // 2
					left = mid + 1 // 3
				} else {
					right = mid - 1 // 2
				}
			}
			dp[pos + 1] = nums[i]
		}
	}

	return dpLen
}

// dp 0 2 3 6 101
// dpLen 4
