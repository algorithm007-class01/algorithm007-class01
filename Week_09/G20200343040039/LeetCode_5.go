package G20200343040039

func longestPalindrome(s string) string {
	if len(s) == 0 || len(s) == 1 {
		return s
	}
	var start, end int
	for index := range s {
		len1 := expandAroundCenter(s, index, index)
		len2 := expandAroundCenter(s, index, index+1)
		var lenMax int
		if len1 > len2 {
			lenMax = len1
		} else {
			lenMax = len2
		}
		if lenMax > end-start {
			start = index - (lenMax-1)/2
			end = index + lenMax/2
		}
	}
	return s[start : end+1]
}

func expandAroundCenter(s string, left, right int) int {
	for ; left >= 0 && right < len(s) && s[left] == s[right]; {
		left--
		right++
	}
	return right - left - 1
}
