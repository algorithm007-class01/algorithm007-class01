#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/word-search-ii/
题目描述
212. Word Search II
Hard

Given a 2D board and a list of words from the dictionary, find all words in the board.
Each word must be constructed from letters of sequentially adjacent cell, where "adjacent"
cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

Example:
Input:
board = [
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
words = ["oath","pea","eat","rain"]
Output: ["eat","oath"]
Note:
All inputs are consist of lowercase letters a-z.
The values of words are distinct.
"""

from typing import List


class Trie:
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = {}
        self.end_of_word = '#'

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        node = self.root
        for ch in word:
            node = node.setdefault(ch, {})
        node[self.end_of_word] = self.end_of_word
        return

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        node = self.root
        for ch in word:
            if ch not in node:
                return False
            node = node[ch]
        return self.end_of_word in node

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        node = self.root
        for ch in prefix:
            if ch not in node:
                return False
            node = node[ch]
        return True


class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        trie = Trie()
        for word in words:
            trie.insert(word)

        def _dfs(i, j, s, cur_dict):
            # terminator
            if '#' in cur_dict: ans.add(s)
            if not (0 <= i < rows and 0 <= j < cols): return
            if board[i][j] == '#': return

            # process
            ch = board[i][j]
            if ch not in cur_dict: return

            # drill down
            board[i][j] = '#'
            directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]
            for d in directions:
                _dfs(i + d[0], j + d[1], s + ch, cur_dict[ch])
            # reverse state
            board[i][j] = ch
            return

        ans = set()
        rows, cols = len(board), len(board[0])
        for i in range(rows):
            for j in range(cols):
                ch = board[i][j]
                if ch in trie.root:
                    _dfs(i, j, '', trie.root)
        return list(ans)
