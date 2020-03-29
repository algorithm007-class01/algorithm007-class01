"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""

class Solution:
    def postorder(self, root: 'Node') -> List[int]:
        # 递归
        # res = []
        # def help(root):
        #     if not root:
        #         return
        #     for child in root.children:
        #         help(child)
        #     res.append(root.val)
        # help(root)
        # return res

        #迭代
        stack = [root]
        res = []
        while stack:
            i = stack.pop()
            if isinstance(i, Node):
                stack.extend([child for child in i.children])
                stack.append(i.val)
            elif isinstance(i, int):
                res.append(i)
        return res[::-1]