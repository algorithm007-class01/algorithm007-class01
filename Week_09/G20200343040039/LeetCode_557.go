package G20200343040039

func reverseWords_1(s string) string {
	result := make([]byte, len(s))
	copy(result, s)

	wordStart := 0
	wordEnd := 0

	for i := 0; i < len(s); i++ {
		if result[i] == ' ' {
			wordEnd = i - 1
			reverse(result, wordStart, wordEnd)
			wordStart = i + 1
		}
	}

	wordEnd = len(s) - 1

	reverse(result, wordStart, wordEnd)

	return string(result)
}

func reverse(result []byte, start int, end int) {
	for start < end {
		result[start], result[end] = result[end], result[start]
		start++
		end--
	}
}

