#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/generate-parentheses/
题目描述
297. Serialize and Deserialize Binary Tree
Hard
Serialization is the process of converting a data structure or object into a sequence of bits
so that it can be stored in a file or memory buffer, or transmitted across a network
connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on
how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree
can be serialized to a string and this string can be deserialized to the original tree structure.

Example:
You may serialize the following tree:

    1
   / \
  2   3
     / \
    4   5

as "[1,2,3,null,null,4,5]"
Clarification: The above format is the same as how LeetCode serializes a binary tree.
You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms
should be stateless.]
"""

from typing import List


# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.

        :type root: TreeNode
        :rtype: str
        """
        # # 解法1 前序遍历序列化
        # if not root: return '#'
        # s = str(root.val) + ',' + self.serialize(root.left) + ',' + self.serialize(root.right)
        # return s

        # 解法2 层序遍历序列化
        if not root: return '#'

        from collections import deque
        queue = deque([root])
        res = []
        while queue:
            node = queue.popleft()
            if node:
                res.append(str(node.val))
                queue.extend([node.left, node.right])
            else:
                res.append('#')
        return ','.join(res)

    def deserialize(self, data):
        """Decodes your encoded data to tree.

        :type data: str
        :rtype: TreeNode
        """
        # # 解法1 前序遍历序列化
        # data = data.split(',')
        # def _deserial():
        #     if not data: return
        #     v = data.pop(0)
        #     if v == '#': return
        #     node = TreeNode(v)
        #     node.left = _deserial()
        #     node.right = _deserial()
        #     return node
        #
        # root = _deserial()
        # return root

        # 解法2 层序遍历序列化
        from collections import deque
        data = deque(data.split(','))
        if not data or data[0] == '#':
            return

        root = TreeNode(data.popleft())
        queue = deque([root])
        while data and queue:
            node = queue.popleft()

            v = data.popleft()
            if v != '#':
                node.left = TreeNode(v)
                queue.append(node.left)
            v = data.popleft()
            if v != '#':
                node.right = TreeNode(v)
                queue.append(node.right)
        return root



# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.deserialize(codec.serialize(root))
