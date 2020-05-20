package G20200343040039

func findAnagrams(s string, p string) []int {
	pHash := [26]int{}

	for i := 0; i < len(p); i++ {
		pHash[p[i] - 'a']++
	}

	result := make([]int, 0)
	tempHash := [26]int{}

	for i := 0; i < len(s); i++ {
		tempHash[s[i] - 'a']++

		if i + 1 >= len(p) {
			if pHash[s[i] - 'a'] > 0 {
				if tempHash == pHash {
					result = append(result, i - len(p) + 1)
				}
			}

			tempHash[s[i - len(p) + 1] - 'a']--
		}
	}

	return result
}