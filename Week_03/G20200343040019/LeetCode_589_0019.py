"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""
class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        # 递归
        # if root is None:
        #     return None
        # if root.children is None:
        #     return [root.val]
        # res = [root.val]
        # for c in root.children:
        #     res = res + self.preorder(c)
        # return res
        # 迭代
        res = []
        stack = [root]
        while stack:
            curr = stack.pop()
            if curr:
                res.append(curr.val)
                if curr.children:
                    for i in range(len(curr.children)-1,-1,-1):
                        stack.append(curr.children[i])

        return res