#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/word-ladder-ii/description/
题目描述
126. Word Ladder II
Hard
Given two words (beginWord and endWord), and a dictionary's word list, find all
shortest transformation sequence(s) from beginWord to endWord, such that:

Only one letter can be changed at a time
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:
Return an empty list if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]
Output:
[
  ["hit","hot","dot","dog","cog"],
  ["hit","hot","lot","log","cog"]
]

Example 2:
Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: []
Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
"""

from typing import List


class Solution:
    def findLadders(self, beginWord: str, endWord: str, wordList: List[str]) -> List[List[str]]:
        # 解法1 广度优先遍历
        if not wordList or endWord not in wordList: return []

        from collections import defaultdict
        commb = defaultdict(list)
        for word in wordList:
            for i in range(len(word)):
                commb[word[:i] + '*' + word[i + 1:]].append(word)
        from collections import deque
        queue = deque([[beginWord]])
        min_length = float('inf')
        level = 0
        visited = {beginWord: level}

        ans = []
        while queue:
            for _ in range(len(queue)):
                path = queue.popleft()
                last = path[-1]
                if last == endWord:
                    ans.append(path)
                    min_length = min(len(path), min_length)
                    continue

                for i in range(len(last)):
                    c = last[:i] + '*' + last[i + 1:]
                    for word in commb[c]:
                        # todo 去重
                        if word == last: continue
                        # todo IMPORTANT 剪枝, 当前level > 访问过的深度, continue
                        if word in visited and visited[word] < level: continue
                        # todo 剪枝
                        if len(path) >= min_length: continue

                        visited[word] = level
                        queue.append(path + [word])
            level += 1
        return ans


res = Solution().findLadders("hit", "cog", ["hot", "dot", "dog", "lot", "log", "cog"])
print(res)

res = Solution().findLadders("hit", "cog", ["hot", "dot", "dog", "lot", "log"])
print(res)

res = Solution().findLadders("hot", "dog", ["hot", "dog"])
print(res)
