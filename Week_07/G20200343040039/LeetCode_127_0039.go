package G20200343040039

func ladderLength(beginWord string, endWord string, wordList []string) int {
	cache := make(map[string]bool)

	for _, value := range wordList {
		cache[value] = true
	}

	if _, exist := cache[endWord]; !exist {
		return 0
	}

	levelSet1 := make(map[string]bool)
	levelSet2 := make(map[string]bool)
	levelSet1[beginWord] = true
	levelSet2[endWord] = true

	wordLen := len(beginWord)

	steps := 0

	for len(levelSet1) > 0 && len(levelSet2) > 0 {
		steps++

		if len(levelSet1) > len(levelSet2) {
			levelSet1, levelSet2 = levelSet2, levelSet1
		}

		tempLevelSet := make(map[string]bool)

		for word := range levelSet1 {
			wordChars := []rune(word)

			for i := 0; i < wordLen; i++ {
				originChar := wordChars[i]

				for char := 'a'; char <= 'z'; char++ {
					wordChars[i] = char
					tempWord := string(wordChars)

					if _, exist := levelSet2[tempWord]; exist {
						return steps + 1
					}

					if _, exist := cache[tempWord]; !exist {
						continue
					}

					delete(cache, tempWord)
					tempLevelSet[tempWord] = true
				}
				wordChars[i] = originChar
			}
		}
		levelSet1 = tempLevelSet
	}

	return 0
}
