#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/binary-tree-level-order-traversal/
题目描述
102. Binary Tree Level Order Traversal
Medium
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
"""

from typing import List


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        # # 解法1 BFS遍历
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
        #     ans.append(level)
        # return ans

        # 解法2 DFS遍历
        if not root: return []

        def _dfs(level, node):
            if not node: return
            if level == len(ans):
                ans.append([])
            ans[level].append(node.val)
            _dfs(level + 1, node.left)
            _dfs(level + 1, node.right)
            return

        ans = []
        _dfs(0, root)
        return ans
