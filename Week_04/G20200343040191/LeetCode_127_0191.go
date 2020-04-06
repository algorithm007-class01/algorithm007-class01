func ladderLength(beginWord string, endWord string, wordList []string) int {
	wordMap := make(map[string]struct{})
	for _, word := range wordList {
		if word != beginWord {
			wordMap[word] = struct{}{}
		}
	}
    if _, ok := wordMap[endWord]; !ok {
        return 0
    }
	que := []string{beginWord}
	depth := 0
	for len(que) > 0 {
		depth++
        qLen := len(que)
		for i := 0; i < qLen; i++ {
			word := que[0]
            ch := []rune(word)
			que = que[1:]
            for c := 'a'; c <= 'z'; c++ {
                for j := 0; j < len(word); j++ {
                    if ch[j] != c {
                        candidate := word[:j]+string(c)+word[j+1:]
                        if _, ok := wordMap[candidate]; ok {
                            if candidate == endWord {
                                return depth + 1
                            }
                            delete(wordMap, candidate)
                            que = append(que, candidate)
                        }
                    }
                }
            }
		}
	}
	return 0
}
