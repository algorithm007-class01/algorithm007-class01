#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/minimum-depth-of-binary-tree/
题目描述
111. Minimum Depth of Binary Tree
Easy
Given a binary tree, find its minimum depth.
The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
Note: A leaf is a node with no children.

Example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its minimum depth = 2.
"""


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def minDepth(self, root: TreeNode) -> int:
        # # 解法1 求深度
        # if not root: return 0
        # if not root.left and not root.right: return 1
        # left = self.minDepth(root.left)
        # right = self.minDepth(root.right)
        # if left == 0: return right + 1
        # if right == 0: return left + 1
        # return min(left, right) + 1

        # # # 解法2 另一种递归方式
        # if not root: return 0
        # if not root.left: return 1 + self.minDepth(root.right)
        # if not root.right: return 1 + self.minDepth(root.left)
        # return 1 + min(self.minDepth(root.right), self.minDepth(root.left))

        # # 解法2.1
        # if not root: return 0
        # left = self.minDepth(root.left)
        # right = self.minDepth(root.right)
        # return ((left or right) if (left == 0 or right == 0) else min(left, right)) + 1

        # 解法3 迭代, 层序遍历BFS
        if not root: return 0
        from collections import deque
        queue = deque([root])
        depth = 0
        while queue:
            depth += 1
            for _ in range(len(queue)):
                node = queue.popleft()
                if not node.left and not node.right: return depth
                if node.left: queue.append(node.left)
                if node.right: queue.append(node.right)
        return depth
