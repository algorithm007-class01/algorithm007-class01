package G20200343040039

func isIsomorphic(s string, t string) bool {
	return isIsomorphicHelper(s, t) && isIsomorphicHelper(t, s)
}

func isIsomorphicHelper(s string, t string) bool {
	length := len(s)
	cache := make(map[byte]byte)

	for i := 0; i < length; i++ {
		if _, exists := cache[s[i]]; exists {
			if cache[s[i]] != t[i] {
				return false
			}
		} else {
			cache[s[i]] = t[i]
		}
	}

	return true
}


func isIsomorphic_1(s string, t string) bool {
	length := len(s)

	cacheS := [128]int{}
	cacheT := [128]int{}

	for i := 0; i < length; i++ {
		char1 := s[i]
		char2 := t[i]

		if cacheS[char1] != cacheT[char2] {
			return false
		} else {
			if cacheS[char1] == 0 {
				cacheS[char1] = i + 1
				cacheT[char2] = i + 1
			}
		}
	}

	return true
}