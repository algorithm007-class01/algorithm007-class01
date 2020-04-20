#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/invert-binary-tree/description/
题目描述
226. Invert Binary Tree
Easy
Invert a binary tree.

Example:
Input:
     4
   /   \
  2     7
 / \   / \
1   3 6   9
Output:

     4
   /   \
  7     2
 / \   / \
9   6 3   1
Trivia:
This problem was inspired by this original tweet by Max Howell:
Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so f*** off.
"""

from typing import List


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def invertTree(self, root: TreeNode) -> TreeNode:
        # # 解法1 递归
        # if not root: return
        # root.left, root.right = root.right, root.left
        # self.invertTree(root.left)
        # self.invertTree(root.right)
        # return root

        # # 解法 1.2
        # if not root: return
        # root.left, root.right = self.invertTree(root.right), self.invertTree(root.left)
        # return root

        # 解法2 层序遍历
        if not root: return
        from collections import deque
        stack = deque([root])
        while stack:
            node = stack.popleft()
            node.left, node.right = node.right, node.left
            if node.left: stack.append(node.left)
            if node.right: stack.append(node.right)
        return root
