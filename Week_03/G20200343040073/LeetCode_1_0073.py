"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""
# solution 1
class Solution:
    def print(self, node: 'Node', p: List[int]):
        if not node: return
        if node.children:
            for n in node.children:
                self.print(n,p)
        p.append(node.val)
    def postorder(self, root: 'Node') -> List[int]:
        result = []
        self.print(root, result)
        return result

# solution 2
class Solution:
    def postorder(self, root: 'Node') -> List[int]:
        if not root: return []
        if not root.children: return [root.val]
        l = []
        for n in root.children: l += self.postorder(n)
        return l + [root.val]
