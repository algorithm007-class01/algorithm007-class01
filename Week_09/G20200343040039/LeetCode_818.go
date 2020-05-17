package G20200343040039

import "math"

func longestValidParentheses(s string) int {
	left := 0
	right := 0
	maxLength := 0

	for i := 0; i < len(s); i++ {
		if s[i] == '(' {
			left++
		} else {
			right++
		}

		if left == right {
			maxLength = int(math.Max(float64(maxLength), float64(2 * right)))
		} else if right >= left {
			left = 0
			right = 0
		}
	}

	left = 0
	right = 0

	for i := len(s) - 1; i >= 0; i-- {
		if s[i] == '(' {
			left++
		} else {
			right++
		}

		if left == right {
			maxLength = int(math.Max(float64(maxLength), float64(2 * left)))
		} else if left >= right {
			left = 0
			right = 0
		}
	}

	return maxLength
}
