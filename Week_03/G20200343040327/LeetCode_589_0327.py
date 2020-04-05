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
        #     res.append(root.val)
        #     for child in root.children:
        #         help(child)
        # help(root)
        # return res

        # 迭代
        stack, res = [root], []
        while stack:
            i = stack.pop()
            if isinstance(i, Node):
                stack.append(i.val)
                stack.extend([child for child in i.children])
            elif isinstance(i, int):
                res.append(i)
        return res[::-1]