package G20200343040039

func ladderLength(beginWord string, endWord string, wordList []string) int {
	if !containEndWord(endWord, wordList) {
		return 0
	}
	level := 0

	queue := make([]string, 0)
	queue = append(queue, beginWord)

	visited := make([]bool, len(wordList))

	for len(queue) > 0 {
		queueSize := len(queue)
		level++
		for queueSize > 0 {
			curWord := queue[0]
			queue = queue[1:]
			for i := 0; i < len(wordList); i++ {
				if !visited[i] {
					if isValidWord(curWord, wordList[i]) {
						if wordList[i] == endWord {
							return level+1
						}
						queue = append(queue, wordList[i])
						visited[i] = true
					}
				}
			}

			queueSize--
		}

	}

	return 0
}

func containEndWord(endWord string, wordList []string) bool {
	for _, word := range wordList {
		if endWord == word {
			 return true
		}
	}

	return false
}

func isValidWord(curWord string, nextWord string) bool {
	diffCount := 0
	for i := 0;i < len(nextWord); i++ {
		if curWord[i] != nextWord[i] {
			diffCount++
		}
	}

	return diffCount == 1
}