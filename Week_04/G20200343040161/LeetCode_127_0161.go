package G20200343040161

func ladderLength(beginWord string, endWord string, wordList []string) int {
	marked := make([]bool, len(wordList))
	result := 1
	queue := make([]string, 0)
	queue = append(queue, beginWord)
	for len(queue) != 0 {
		result++
		level := len(queue)
		for i := 0; i < level; i++ {
			for k, word := range wordList {
				if word != beginWord && !marked[k] {
					dCnt := diff(word, queue[i])
					if dCnt == 1 {
						marked[k] = true
						if wordList[k] == endWord {
							return result
						}
						queue = append(queue, wordList[k])
					}
				}
			}
		}
		queue = queue[level:]
	}
	return 0
}

func diff(x, y string) int {
	if len(x) != len(y) {
		return 0
	}
	diff := 0
	for i := 0; i < len(x); i++ {
		if x[i] != y[i] {
			diff++
		}
	}
	return diff
}