package G20200343040039


func isPowerOfTwo(n int) bool {
	if n == 0 {
		return false
	}

	return (n & (n - 1)) == 0
}