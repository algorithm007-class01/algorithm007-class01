"""
590. N叉树的后序遍历
给定一个 N 叉树，返回其节点值的前序遍历。
"""

"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""
class Solution:
    def preorder(self, root: 'Node') -> list:
        def order(root,result):
            if not root:
                return
            result.append(root.val)
            for item in root.children:
                order(item, result)
                

        result = list()
        order(root, result)
        return result