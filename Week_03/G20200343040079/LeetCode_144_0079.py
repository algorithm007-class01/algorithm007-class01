#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

"""
题目描述
144. Binary Tree Preorder Traversal
Medium

Given a binary tree, return the preorder traversal of its nodes' values.
Example:
Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,2,3]
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
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        # # 解法1 递归遍历
        # if not root: return []
        # def _traversal(root):
        #     if not root: return
        #     ans.append(root.val)
        #     _traversal(root.left)
        #     _traversal(root.right)
        #
        # ans = []
        # _traversal(root)
        # return ans

        # # 解法1.1 递归遍历
        # if not root: return []
        # left = self.preorderTraversal(root.left)
        # right = self.preorderTraversal(root.right)
        # return [root.val] + left + right

        # # 解法2 stack 迭代实现
        # if not root: return []
        # from collections import deque
        # stack = deque()
        # ans = []
        # while stack or root:
        #     if root:
        #         ans.append(root.val)
        #         stack.append(root)
        #         root = root.left
        #     elif stack:
        #         root = stack.pop().right
        # return ans

        # # 解法2.1 stack 迭代实现
        # if not root: return []
        # stack = []
        # cur = root
        # ans = []
        # while cur or stack:
        #     while cur:
        #         ans.append(cur.val)
        #         stack.append(cur)
        #         cur = cur.left
        #     top = stack.pop()
        #     cur = top.right
        # return ans

        # 解法3 stack 颜色标记法, 记录节点是第几次访问
        if not root: return []
        first, second = 1, 2
        stack = [(first, root)]
        ans = []
        while stack:
            times, node = stack.pop()
            if not node: continue
            if times == first:
                stack.append((first, node.right))
                stack.append((first, node.left))
                stack.append((second, node))
            elif times == second:
                ans.append(node.val)
        return ans
