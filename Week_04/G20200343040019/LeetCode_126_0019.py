class Solution:
    def findLadders(self, beginWord: str, endWord: str, wordList: List[str]) -> List[List[str]]:
        from collections import defaultdict
        if endWord not in wordList: return []

        dickey = defaultdict(list)
        L = len(beginWord)
        
        for w in wordList:
            for i in range(L):
                k = w[:i]+"*"+w[i+1:]
                dickey[k].append(w)

        worddic = defaultdict(set)
        queue = {beginWord}
        backqueue = {endWord}
        visited = set()
        ansdeep = sys.maxsize
        flag = True
        while queue:
            if len(queue) > len(backqueue):
                queue,backqueue, flag = backqueue,queue, not flag

            nextall = set()
            visited+=queue
            for curr in queue:
                nkey = [curr[:i]+"*"+curr[i+1:] for i in range(L)]
                for key in nkey:
                    for word in dickey[key]:
                        if word not in visited:
                            nextall.add(word)
                            if flag:
                                worddic[word].add(curr)
                            else:
                                worddic[curr].add(word)
            if nextall & backqueue:
                break
            queue = nextall
        if endWord in worddic:
            res = [[endWord]]
            while res[0][0] != beginWord:
                res = [[x]+ r  for r in res for x in worddic[r[0]]]
            return res
        return []