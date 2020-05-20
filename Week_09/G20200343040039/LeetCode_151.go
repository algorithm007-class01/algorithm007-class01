package G20200343040039

func reverseWords(s string) string {
	result := make([]byte, 0)

	index := len(s) - 1
	for index >= 0 {
		if s[index] == ' ' {
			index--
			continue
		}

		left := index
		right := index
		for left >= 0 {
			if s[left] == ' ' {
				break
			}
			left--
		}

		for i := left + 1; i <= right; i++ {
			result = append(result, s[left])
		}
		result = append(result, ' ')
		index = left
	}

	return string(result)
}