package G20200343040039

import "math"

func reverseStr(s string, k int) string {
	result := make([]byte, len(s))
	copy(result, s)

	for start := 0; start < len(s); start += 2 * k {
		left := start
		right := int(math.Min(float64(start + k - 1), float64(len(s) - 1)))

		for left < right {
			result[left], result[right] = result[right], result[left]
			left++
			right--
		}
	}

	return string(result)
}
