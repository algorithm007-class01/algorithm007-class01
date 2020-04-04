#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/maximum-depth-of-binary-tree/
题目描述
104. Maximum Depth of Binary Tree
Easy
Given a binary tree, find its maximum depth.
The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
Note: A leaf is a node with no children.
Example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its depth = 3.
"""


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def maxDepth(self, root: TreeNode) -> int:
        # # 解法1 递归实现 DFS
        # if not root: return 0
        # if not root.left and not root.right: return 1
        # return max(self.maxDepth(root.left), self.maxDepth(root.right)) + 1

        # 解法2 层序遍历BFS
        if not root: return 0
        from collections import deque
        stack = deque([root])
        depth = 0
        while stack:
            depth += 1
            for _ in range(len(stack)):
                node = stack.popleft()
                if node.left: stack.append(node.left)
                if node.right: stack.append(node.right)
        return depth
