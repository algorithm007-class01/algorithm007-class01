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
        # if not root:
        #     return []
        # if not root.children:
        #     return [root.val]
        # res = []
        # for i in range(len(root.children)):
        #     res = res + self.postorder(root.children[i])        
        # res = res + [root.val]
        # return res
        # 迭代
        if root is None:
            return []
        stack, output = [root, ], []
        while stack:
            root = stack.pop()
            if root is not None:
                output.append(root.val)
            for c in root.children:
                stack.append(c)
                
        return output[::-1]