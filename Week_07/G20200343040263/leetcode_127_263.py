# 单词接龙 采用广度优先搜索 队列，先进先出
class Solution(object):
    def ladderLength(self, beginWord, endWord, wordList):
        word_set = set(wordList)
        q = [(beginWord, 1)]
        if endWord not in wordList:
            return 0
        while q:
            cur_word, level = q.pop()
            if cur_word == endWord:
                return level
            for i in range(len(cur_word)):
                for j in 'abcdefghijklmnopqrstuvwxyz':
                    new_word = cur_word[:i] + j + cur_word[i+1:]
                    if new_word in wordList:
                        q.append((new_word, level+1))
                        wordList.remove(new_word)
        return 0
# 双端BFS
class Solution(object):
    def ladderLength(self, beginWord, endWord, wordList):
        if endWord not in wordList: return 0
        front = {beginWord}
        back = {endword}
        dist = 1
        wordList = set(wordList)
        word_len = len(beginWord)
        # BFS
        while front and back:
            # 为什么在这里dist+1
            dist += 1
            next_front = set()
            for word in front:
                for i in range(word_len):
                    for c in 'abcdefghijklmnopqrstuvwxyz':
                        if c != word[i]:
                            new_word = word[:i] + c + word[i+1:]
                            # 说明相交
                            if new_word in back:
                                return dist
                            if new_word in wordList:
                                next_front.add(new_word)
                                wordList.remove(new_word)
            front = next_front
            if len(back) < len(front):
                back, front = front, back
        return 0