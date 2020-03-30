#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

"""
题目描述
590. N-ary Tree Postorder Traversal
Given an n-ary tree, return the postorder traversal of its nodes' values.
Nary-Tree input serialization is represented in their level order traversal, each group of children
is separated by the null value (See examples).

Follow up:
Recursive solution is trivial, could you do it iteratively?

Example 1:
Input: root = [1,null,3,2,4,null,5,6]
Output: [5,6,3,2,4,1]
Example 2:

Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
Output: [2,6,14,11,7,3,12,8,4,13,9,10,5,1]
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
    def postorder(self, root: 'Node') -> List[int]:
        # # 解法1 递归
        # if not root: return []
        # def _traversal(root):
        #     if not root: return
        #     for child in root.children:
        #         _traversal(child)
        #     ans.append(root.val)
        #     return
        #
        # ans = []
        # _traversal(root)
        # return ans

        # # 解法2 颜色标记法, 记录访问节点的次数
        # if not root: return []
        # first, second = 1, 2
        # from collections import deque
        # stack = deque([(first, root)])
        # ans = []
        # while stack:
        #     times, node = stack.pop()
        #     if not node: continue
        #     if times == first:
        #         stack.append((second, node))
        #         for child in node.children[::-1]:
        #             stack.append((first, child))
        #     elif times == second:
        #         ans.append(node.val)
        # return ans

        # 解法3 先求出来“根-右-左”, 再反转
        if not root: return []
        from collections import deque
        stack = deque([root])
        ans = deque()
        while stack:
            node = stack.pop()
            ans.appendleft(node.val)
            for child in node.children:
                stack.append(child)
        return list(ans)
