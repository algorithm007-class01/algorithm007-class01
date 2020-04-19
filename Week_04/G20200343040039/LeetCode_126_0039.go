package G20200343040039

func findLadders(beginWord string, endWord string, wordList []string) [][]string {
	result := make([][]string, 0)

	wordsCache := make(map[string]struct{}) // 把word存入字典
	for _, word := range wordList {
		wordsCache[word] = struct{}{} // 可以利用字典快速添加、删除和查找单词
	}
	if _, ok := wordsCache[endWord]; !ok {
		return result
	}

	// 存放关系：每个单词可达的下层单词
	levelCache := make(map[string]map[string]struct{})
	beginLevel := make(map[string]struct{})
	endLevel := make(map[string]struct{})

	beginLevel[beginWord] = struct{}{}
	endLevel[endWord] = struct{}{}

	if buildTree(wordsCache, beginLevel, endLevel, levelCache, true) {
		dfs(&result, levelCache, beginWord, endWord, []string{})
	}

	return result
}

func dfs(result *[][]string, levelCache map[string]map[string]struct{}, beginWord string, endWord string, list []string) {
	list = append(list, beginWord)

	if beginWord == endWord {
		newPath := make([]string, len(list))
		copy(newPath, list)
		*result = append(*result, newPath)

		list = list[:len(list) - 1]

		return
	}

	if _, ok := levelCache[beginWord]; ok {
		for word := range levelCache[beginWord] {
			dfs(result, levelCache, word, endWord, list)
		}
	}

	list = list[:len(list) - 1]
}

func buildTree(wordsCache map[string]struct{}, beginLevel map[string]struct{}, endLevel map[string]struct{}, levelCache map[string]map[string]struct{}, isFront bool) bool {
	if len(beginLevel) == 0 {
		return false
	}

	if len(endLevel) < len(beginLevel) {
		return buildTree(wordsCache, endLevel, beginLevel, levelCache, !isFront)
	}

	for word := range beginLevel {
		delete(wordsCache, word)
	}

	isFound := false

	nextLevel := make(map[string]struct{})

	for curLevelWord := range beginLevel {
		wordChars := []rune(curLevelWord)

		for i := 0; i < len(wordChars); i++ {
			charBackup := wordChars[i]

			for char := 'a'; char <= 'z'; char++ {
				wordChars[i] = char
				nextLevelWord := string(wordChars)

				if _, ok := wordsCache[nextLevelWord]; ok {
					nextLevel[nextLevelWord] = struct{}{}

					if !isFront {
						curLevelWord, nextLevelWord = nextLevelWord, curLevelWord
					}

					if _, ok := endLevel[nextLevelWord]; ok {
						isFound = true
					}

					if _, ok := levelCache[curLevelWord]; !ok {
						levelCache[curLevelWord] = make(map[string]struct{})
					}

					levelCache[curLevelWord][nextLevelWord] = struct{}{}
				}
			}

			wordChars[i] = charBackup
		}
	}

	if isFound {
		return true
	}

	return buildTree(wordsCache, nextLevel, endLevel, levelCache, isFound);
}