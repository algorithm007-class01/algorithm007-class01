"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""
# solution 1
class Solution:
    def print(self, nodes: List, p: List[List[int]]):
        if not nodes: return
        valList,nextList = [],[]
        for n in nodes:
            valList.append(n.val)
            if n.children:
                nextList += n.children
        p.append(valList)
        self.print(nextList, p)
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        if not root: return []
        result = []
        self.print([root], result)
        return result

# solution 2
class Solution:
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        if not root: return []
        d,result=[root],[]
        while d:
            p,od = [],[]
            for n in d:
                p.append(n.val)
                if n.children: od += n.children
            d = od
            result.append(p)
        return result
