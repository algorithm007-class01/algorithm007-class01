#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/word-ladder/description/
题目描述
127. Word Ladder
Medium
Given two words (beginWord and endWord), and a dictionary's word list,
find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Example 2:
Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.]
"""

from typing import List


class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        # # 解法1 广度优先遍历BFS
        # if not beginWord or not endWord or not wordList or len(beginWord) != len(endWord): return 0
        #
        # wordList = set(wordList)
        # if endWord not in wordList: return 0
        #
        # import string
        # from collections import deque
        # q = deque([beginWord])
        # cnt = 1
        # while q:
        #     for _ in range(len(q)):
        #         s = q.popleft()
        #         if s == endWord: return cnt
        #         for i in range(len(s)):
        #             for c in string.ascii_lowercase:
        #                 new = s[:i] + c + s[i + 1:]
        #                 if new in wordList:
        #                     q.append(new)
        #                     wordList.remove(new)
        #     cnt += 1
        # return 0

        # # 解法1.1 广度优先遍历BFS
        # if not wordList: return 0
        # from collections import defaultdict
        # commb = defaultdict(list)
        # for word in wordList:
        #     for i in range(len(word)):
        #         commb[word[:i] + '*' + word[i+1:]].append(word)
        #
        # from collections import deque
        # queue = deque([beginWord])
        # level = 0
        # while queue:
        #     level += 1
        #     for _ in range(len(queue)):
        #         word = queue.popleft()
        #         if word == endWord: return level
        #         for i in range(len(word)):
        #             new = word[:i] + '*' + word[i+1:]
        #             if new in commb:
        #                 queue.extend(commb[new])
        #                 commb[new] = []
        # return 0

        # # 解法2 深度优先遍历Depth first search
        # # 有 bug, 超时跑不出来结果
        # if not beginWord or not endWord or not wordList or len(beginWord) != len(endWord): return 0
        # wordList = set(wordList)
        # if endWord not in wordList: return 0
        #
        # import string
        #
        # def _dfs(cnt, beginWord):
        #     if beginWord == endWord:
        #         nonlocal ans
        #         ans = min(cnt, ans) if ans != 0 else cnt
        #         print(ans)
        #         return
        #
        #     for i in range(len(beginWord)):
        #         for c in string.ascii_lowercase:
        #             new = beginWord[:i] + c + beginWord[i + 1:]
        #             print(new)
        #             if new in wordList:
        #                 print(new)
        #                 wordList.remove(new)
        #                 _dfs(cnt + 1 if beginWord[i] != c else cnt, new)
        #                 wordList.add(new)
        #     return
        #
        # ans = 0
        # _dfs(1, beginWord)
        # return ans

        # 解法3 双向BFS, two-end bfs
        if not wordList: return 0
        wordList = set(wordList)
        if endWord not in wordList: return 0

        import string
        f, b = {beginWord}, {endWord}   # front, back
        level = 1
        while f:
            new_f = set()
            level += 1
            for word in f:
                for i in range(len(word)):
                    for c in string.ascii_lowercase:
                        new_word = word[:i] + c + word[i+1:]
                        if new_word in b:
                            return level
                        if new_word in wordList:
                            new_f.add(new_word)
                            wordList.remove(new_word)   # 相当于visited了
            f = new_f
            if len(f) > len(b):
                f, b = b, f
        return 0


res = Solution().ladderLength("hit", "cog", ["hot", "dot", "dog", "lot", "log", "cog"])
print(res, res == 5)

res = Solution().ladderLength("hot", "dog", ["hot", "dog", "dot"])
print(res, res == 3)

res = Solution().ladderLength("qa", "sq",
                              ["si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln", "tm", "le", "av",
                               "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya", "cr",
                               "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as",
                               "fr", "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz",
                               "no", "bi", "di", "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st",
                               "er", "sc", "ne", "mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr",
                               "pa", "he", "lr", "sq", "ye"])
print(res, res == 5)
