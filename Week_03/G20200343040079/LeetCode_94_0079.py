#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

"""
题目描述
94. Binary Tree Inorder Traversal
Medium
Given a binary tree, return the inorder traversal of its nodes' values.

Example:
Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
Follow up: Recursive solution is trivial, could you do it iteratively?
"""

from typing import List


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        # # 解法1 递归方式
        # if not root: return []
        #
        # def _traversal(root):
        #     if not root: return
        #     _traversal(root.left)
        #     ans.append(root.val)
        #     _traversal(root.right)
        # ans = []
        # _traversal(root)
        # return ans

        # # 解法1.1 递归解法
        # if not root: return []
        # left = self.inorderTraversal(root.left)
        # right = self.inorderTraversal(root.right)
        # return left + [root.val] + right

        # # 解法2 用stack
        # if not root: return []
        #
        # from collections import deque
        # stack = deque()
        # ans = []
        # while stack or root:
        #     if root:
        #         stack.append(root)
        #         root = root.left
        #     elif stack:
        #         root = stack.pop()
        #         ans.append(root.val)
        #         root = root.right
        # return ans

        # # 解法 2.1 用stack
        # if not root: return []
        # stack = []
        # cur = root
        # ans = []
        # while stack or cur:
        #     while cur:
        #         stack.append(cur)
        #         cur = cur.left
        #     cur = stack.pop()
        #     ans.append(cur.val)
        #     cur = cur.right
        # return ans

        # 解法3 stack 颜色标记法, 其实是记录是第几次访问节点。
        # 这种解法的前中后续遍历写法，可以统一
        if not root: return []
        first, second = 0, 1
        stack = [(first, root)]
        ans = []
        while stack:
            times, node = stack.pop()
            if not node: continue
            if times == first:
                stack.append((first, node.right))
                stack.append((second, node))
                stack.append((first, node.left))
            else:
                ans.append(node.val)
        return ans

        # 解法4 莫里斯遍历: 其实是将树结构改变成了链表
