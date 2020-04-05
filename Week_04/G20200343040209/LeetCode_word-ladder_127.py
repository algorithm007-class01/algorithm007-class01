class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        from collections import deque, defaultdict
        # 先验判断
        if endWord not in wordList:
            return 0
        intermidiateWords = defaultdict(list)
        wordLen = len(beginWord)
        for word in wordList:
            for i in range(wordLen):
                intermidiateWords[word[:i] + '*' + word[i + 1:]].append(word)
        queue = deque()
        memo = set()
        queue.append(beginWord)
        memo.add(beginWord)
        step = 1
        while queue:
            size = len(queue)
            for _ in range(size):
                curWord = queue.popleft()
                for i in range(wordLen):
                    intermidiateCurWord = curWord[:i] + '*' + curWord[i + 1:]
                    for word in intermidiateWords[intermidiateCurWord]:
                        if word == endWord:
                            return step + 1
                        if word not in memo:
                            queue.append(word)
                            memo.add(word)
            step += 1
        else:
            return 0
