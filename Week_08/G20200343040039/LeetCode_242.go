package G20200343040039

func isAnagram(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}

	counter := make([]byte, 26, 26)
	for i := 0; i < len(s); i++ {
		counter[s[i] - 'a']++
		counter[t[i] - 'a']--
	}

	for i := 0; i < len(counter); i++ {
		if counter[i] != 0 {
			return false
		}
	}

	return true
}