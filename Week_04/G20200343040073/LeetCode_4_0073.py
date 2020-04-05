from collections import defaultdict
class Solution:
    def findLadders(self, beginWord: str, endWord: str, wordList: List[str]) -> List[List[str]]:
        def trackBack(cur = [[beginWord]], visited = [[beginWord]], mem = [beginWord]):
            if result or not cur: return
            newList = []
            newVisited = []
            newMem = []
            for j in range(len(cur)):
                wordList = cur[j]
                visitedList = visited[j]
                w = wordList[-1]
                for i in range(len(w)):
                    for m in dic[w[:i] + '*' + w[i + 1:]]:
                        if m in visitedList: continue
                        if m in mem: continue
                        tempList = wordList[:] + [m]
                        tempVisited = visitedList[:] + [m]
                        if m == endWord: result.append(tempList)
                        newList.append(tempList)
                        newVisited.append(tempVisited)
                        if m not in newMem: newMem.append(m)
            mem += newMem
            print(newList)
            trackBack(newList, newVisited)
        result = []
        if endWord not in wordList: return result
        dic = defaultdict(list)
        for word in wordList:
            for i in range(len(word)):
                dic[word[:i] + '*' + word[i + 1:]].append(word)
        trackBack()
        return result
