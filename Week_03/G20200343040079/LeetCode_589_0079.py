#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

"""
题目描述
589. N-ary Tree Preorder Traversal
Easy
Given an n-ary tree, return the preorder traversal of its nodes' values.
Nary-Tree input serialization is represented in their level order traversal,
each group of children is separated by the null value (See examples).

Follow up:
Recursive solution is trivial, could you do it iteratively?

Example 1:
Input: root = [1,null,3,2,4,null,5,6]
Output: [1,3,5,6,2,4]
Example 2:

Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
Output: [1,2,3,6,7,11,14,4,8,12,5,9,13,10]
Constraints:
The height of the n-ary tree is less than or equal to 1000
The total number of nodes is between [0, 10^4]
"""

from typing import List


# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children


class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        # # 解法1 递归解法
        # if not root: return []
        #
        # def _traversal(root):
        #     if not root: return
        #     res.append(root.val)
        #     for child in root.children:
        #         _traversal(child)
        #     return
        # res = []
        # _traversal(root)
        # return res

        # # 解法1.1 递归解法
        # if not root: return []
        # from functools import reduce
        # ans = [root.val] + reduce(lambda s, child: s + self.preorder(child), root.children, [])
        # return ans

        # # 解法2 用栈
        # if not root: return []
        # from collections import deque
        # stack = deque([root])
        # ans = []
        # while stack:
        #     node = stack.pop()
        #     ans.append(node.val)
        #     for child in node.children[::-1]:
        #         stack.append(child)
        # return ans

        # 解法2.1 颜色标记法, 记录节点的访问次数
        if not root: return []
        first, second = 1, 2
        stack = [(first, root)]
        ans = []
        while stack:
            times, node = stack.pop()
            if not node: continue
            if times == first:
                for child in node.children[::-1]:
                    stack.append((first, child))
                stack.append((second, node))
            elif times == second:
                ans.append(node.val)
        return ans
