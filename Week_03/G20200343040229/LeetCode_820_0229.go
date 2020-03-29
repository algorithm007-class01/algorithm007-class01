func minimumLengthEncoding(words []string) int {
	if words == nil || len(words) == 0 {
		return 0
	}

	for i := 0; i < len(words); i++ {
		words[i] = reverse(words[i])
	}

	sort.Strings(words)
	words = append(words, "#")
	res := 0
	for i := 0; i < len(words) - 1; i++ {
		if strings.HasPrefix(words[i + 1], words[i]) {
			continue
		}

		res += len(words[i]) + 1
	}

	return res
}

func reverse(s string) string {
	bytes := []byte(s)
	left, right := 0, len(bytes) - 1
	for left < right {
		bytes[left], bytes[right] = bytes[right], bytes[left]
		left++
		right--
	}

	return string(bytes)
}
