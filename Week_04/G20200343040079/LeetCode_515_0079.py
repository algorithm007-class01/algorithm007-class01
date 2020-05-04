#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/find-largest-value-in-each-tree-row/
题目描述
515. Find Largest Value in Each Tree Row
Medium
You need to find the largest value in each row of a binary tree.

Example:
Input:
          1
         / \
        3   2
       / \   \
      5   3   9

Output: [1, 3, 9]
"""

from typing import List


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        # # 解法1 BFS
        # if not root: return []
        # from collections import deque
        # q = deque([root])
        # ans = []
        # while q:
        #     homework = None
        #     for _ in range(len(q)):
        #         node = q.popleft()
        #         homework = node.val if homework is None else max(homework, node.val)
        #         if node.left: q.append(node.left)
        #         if node.right: q.append(node.right)
        #     ans.append(homework)
        # return ans

        # # 解法1.1 BFS
        # if not root: return []
        # from collections import deque
        # q = deque([root])
        # ans = []
        # while q:
        #     level = []
        #     for _ in range(len(q)):
        #         node = q.popleft()
        #         level.append(node.val)
        #         if node.left: q.append(node.left)
        #         if node.right: q.append(node.right)
        #     ans.append(max(level))
        # return ans

        # 解法2 DFS
        if not root: return []

        def _dfs(level, root):
            if not root:
                return
            if level == len(ans):
                ans.append([])
            ans[level].append(root.val)
            _dfs(level + 1, root.left)
            _dfs(level + 1, root.right)

        ans = []
        _dfs(0, root)
        return [max(v) for v in ans]
