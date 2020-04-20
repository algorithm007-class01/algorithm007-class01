from collections import defaultdict
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        def trackBack(first = 2, cur = [beginWord]):
            if result or not cur: return
            newList = []
            for w in cur:
                for i in range(len(w)):
                    for n in intermidiateWords[w[:i] + '*' + w[i + 1:]]:
                        if n == endWord:
                            result.append(first)
                            return
                        if n not in visited:
                            newList.append(n)
                            visited.append(n)
            print(newList)
            trackBack(first + 1, newList)
        intermidiateWords = defaultdict(list)
        visited = [beginWord]
        wordLen = len(beginWord)
        for word in wordList:
            for i in range(wordLen):
                intermidiateWords[word[:i] + '*' + word[i + 1:]].append(word)
        
        result = []
        trackBack()
        return result[0] if result else 0
