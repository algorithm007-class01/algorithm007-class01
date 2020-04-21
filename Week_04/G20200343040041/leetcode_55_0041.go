package G20200343040041

func canJump(nums []int) bool {
	flag := 0
	for k, v := range nums {
		if k > flag {
			return false
		}
		flag = max(flag, k+v)
	}
	return true
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
