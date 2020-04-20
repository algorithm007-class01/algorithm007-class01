class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        from collections import defaultdict
        if endWord not in wordList or not endWord or not beginWord or not wordList:
            return 0
        L = len(beginWord)
        com_dict = defaultdict(list)
        for word in wordList:
            for j in range(L):
                com_dict[word[:j]+'*'+word[j+1:]].append(word)
        queue = [(beginWord, 1)]
        visited = {beginWord:True}
        while queue:
            cur_word, level = queue.pop(0)
            for i in range(L):
                inter_word = cur_word[:i] + '*' + cur_word[i+1:]
                for word in com_dict[inter_word]:
                    if word == endWord:
                        return level + 1
                    if word not in visited:
                        visited[word] = True
                        queue.append((word, level + 1))
            com_dict[inter_word] = []
        return 0