func findLadders(beginWord string, endWord string, wordList []string) [][]string {  
    ans := make([][]string, 0)
	wordMap := make(map[string]struct{})
	for _, word := range wordList {
		if word != beginWord {
			wordMap[word] = struct{}{}
		}
	}
    if _, ok := wordMap[endWord]; !ok {
        return [][]string{}
    }
    visited := make(map[string]struct{})
	que := [][]string{[]string{beginWord}}
	depth := 1
    minDepth := len(wordList)
	for len(que) > 0 {
		path := que[0]
        que = que[1:]
        if len(path) > depth {
            for v := range visited {
                delete(wordMap, v)
            }
            visited = make(map[string]struct{})
            if len(path) > minDepth {
                break
            } else {
                depth = len(path)
            }
        }
		word := path[len(path) - 1]
        ch := []rune(word)
        for c := 'a'; c <= 'z'; c++ {
            for j := 0; j < len(word); j++ {
                if ch[j] != c {
                    candidate := word[:j]+string(c)+word[j+1:]
                    if _, ok := wordMap[candidate]; ok {
                        newPath := make([]string, len(path))
                        copy(newPath, path)
                        newPath = append(newPath, candidate)
                        visited[candidate] = struct{}{}
                        if candidate == endWord {
                            minDepth = depth
                            ans = append(ans, newPath)
                        } else {
                            que = append(que, newPath)
                        }
                    }
                }
            }
        }
	}
	return ans
}
