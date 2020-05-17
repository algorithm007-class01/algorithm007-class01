package G20200343040039

func validPalindrome(s string) bool {
	left := 0
	right := len(s) - 1
	for left < right {
		if s[left] != s[right] {
			return isPalindrome(s, left + 1, right) ||  isPalindrome(s, left, right - 1)
		}
		left++
		right--
	}

	return true
}

func isPalindrome(s string, left, right int) bool {
	for left < right {
		if s[left] != s[right] {
			return false
		}
		left++
		right--
	}
	return true
}
