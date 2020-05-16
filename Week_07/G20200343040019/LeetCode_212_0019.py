from collections import defaultdict
class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        if not board or not board[0]:
            return []
        root = "@"
        trie = {}
        for word in words:
            node = trie
            for w in word:
                node = node.setdefault(w, {})
            node[root] = word
       
        N, M = len(board), len(board[0])

        res = set()
        
        def DFS(i,j, trie):
            if "@" in trie:
                res.add(trie["@"])
            temp, board[i][j] = board[i][j], "#"
            for ni,nj in ((i-1,j), (i,j-1),(i+1,j),(i,j+1)):
                if -1<ni<N and -1<nj<M:
                    w = board[ni][nj]
                    if board[ni][nj] not in trie:
                        continue
                    DFS(ni, nj, trie[w])
            board[i][j] = temp

        for i in range(N):
            for j in range(M):
                w = board[i][j]
                if w in trie:
                    DFS(i,j,trie[w])
        return list(res)