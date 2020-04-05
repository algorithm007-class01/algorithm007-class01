"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""
class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        if not root: return []
        d,result = [root],[]
        while d:
            node = d.pop(0)
            result.append(node.val)
            if node.children: d = node.children + d
        return result
