package G20200343040039

func firstUniqChar(s string) int {
	cache := [26]int{}

	for _, value := range s {
		cache[value - 'a']++
	}

	for index, value := range s {
		if cache[value - 'a'] == 1 {
			return index
		}
	}

	return -1
}