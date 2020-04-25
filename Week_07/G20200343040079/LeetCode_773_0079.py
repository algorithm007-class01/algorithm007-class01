#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/sliding-puzzle/
题目描述
773. Sliding Puzzle
Hard
On a 2x3 board, there are 5 tiles represented by the integers 1 through 5, and an empty square represented by 0.
A move consists of choosing 0 and a 4-directionally adjacent number and swapping it.
The state of the board is solved if and only if the board is [[1,2,3],[4,5,0]].
Given a puzzle board, return the least number of moves required so that the state of the board is solved.
If it is impossible for the state of the board to be solved, return -1.

Examples:
Input: board = [[1,2,3],[4,0,5]]
Output: 1
Explanation: Swap the 0 and the 5 in one move.
Input: board = [[1,2,3],[5,4,0]]
Output: -1
Explanation: No number of moves will make the board solved.
Input: board = [[4,1,2],[5,0,3]]
Output: 5
Explanation: 5 is the smallest number of moves that solves the board.
An example path:
After move 0: [[4,1,2],[5,0,3]]
After move 1: [[4,1,2],[0,5,3]]
After move 2: [[0,1,2],[4,5,3]]
After move 3: [[1,0,2],[4,5,3]]
After move 4: [[1,2,0],[4,5,3]]
After move 5: [[1,2,3],[4,5,0]]
Input: board = [[3,2,4],[1,5,0]]
Output: 14
Note:
board will be a 2 x 3 array as described above.
board[i][j] will be a permutation of [0, 1, 2, 3, 4, 5].
"""

from typing import List


class Solution:
    def slidingPuzzle(self, board: List[List[int]]) -> int:
        # 解法1 BFS 广度优先搜索
        seq = board[0] + board[1]
        moves = [(1, 3), (0, 2, 4), (1, 5), (0, 4), (1, 3, 5), (2, 4)]  # todo 方向处理
        visited = {tuple(seq)}
        goal = (1, 2, 3, 4, 5, 0)
        from collections import deque
        q = deque([(seq, seq.index(0), 0)])
        while q:
            for _ in range(len(q)):
                s, now, cnt = q.popleft()
                if tuple(s) == goal: return cnt
                for next in moves[now]:
                    s[next], s[now] = s[now], s[next]   # 交换
                    if tuple(s) not in visited:
                        visited.add(tuple(s))
                        q.append((s[:], next, cnt + 1))
                    s[next], s[now] = s[now], s[next]
        return -1
