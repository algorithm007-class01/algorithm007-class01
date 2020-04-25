package G20200343040041

func ladderLength(beginWord string, endWord string, wordList []string) int {
	wordMap := make(map[string]int, 0)
	for k, word := range wordList {
		if _, ok := wordMap[word]; !ok && word != beginWord {
			wordMap[word] = k
		}
	}
	queue, depth := []string{beginWord}, 0
	for len(queue) > 0 {
		depth++
		n := len(queue)
		for i := 0; i < n; i++ {
			word := queue[0]
			queue = queue[1:]
			bros := getBro(word)
			for _, v := range bros {
				if _, ok := wordMap[v]; ok {
					if v == endWord {
						return depth + 1
					}
					delete(wordMap, v)
					queue = append(queue, v)
				}
			}
		}
	}
	return 0
}

func getBro(word string) []string {
	var bros []string
	for i := 0; i < 26; i++ {
		for j := 0; j < len(word); j++ {
			if word[j] != byte(int('a')+i) {
				bros = append(bros, word[:j]+string(int('a')+i)+word[j+1:])
			}
		}
	}
	return bros
}
