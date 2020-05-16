# 212. 单词搜索 II
class Solution:
    
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        def search(a: int, b: int, pre: str, t: dict, visited: dict):
            if '#' in t:
                result.add(pre)
            for (m, n) in ((1, 0), (0, 1), (-1, 0), (0, -1)):
                _i, _j = a + m, b + n
                if _i < 0 or _i >= bheight or _j < 0 or _j >= bwidth: continue
                if not t.get(board[_i][_j]) or (_i, _j) in visited: continue
                search(_i, _j, pre + board[_i][_j], t[board[_i][_j]], visited | {(_i, _j)})
        trie = {}
        for w in words:
            t = trie
            for char in w:
                t = t.setdefault(char, {})
            t['#'] = True
        bheight, bwidth = len(board), len(board[0])
        result = set()
        for i in range(bheight):
            for j in range(bwidth):
                if board[i][j] in trie: search(i, j, board[i][j], trie[board[i][j]], {(i, j)})
        return list(result)
