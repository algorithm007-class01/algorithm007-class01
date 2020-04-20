from collections import defaultdict
class Solution:

    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if endWord not in wordList or not endWord or not beginWord or not wordList:
            return 0
      
        #BFS
        dic = defaultdict(list)
        for w in wordList:
            for i in range(len(beginWord)):
                dic[w[:i]+'*'+w[i+1:]].append(w)

        queue = [beginWord]
        visited = set()
        level = 1
        while queue:
            L = len(queue)
            for i in range(L):
                word = queue.pop(0)
                if word not in visited:
                    visited.add(word)
                    nk = [word[:i]+"*"+word[i+1:] for i in range(len(word))]
                    for k in nk:
                        nw = dic[k]
                        if endWord in nw:
                            return level+1
                        for w in nw:
                            if w not in visited and w not in queue:
                                queue.append(w)
            level+=1
        
        return 0