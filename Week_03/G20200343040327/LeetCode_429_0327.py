"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""
class Solution:
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        res = []
        if not root:return res
        from collections import deque
        q = deque()
        q.appendleft([root])
        while q:
            i = q.popleft()
            if not i:return res
            res.append([])
            q.append([])
            for brother in i:
                res[-1].extend([brother.val])
                q[-1].extend([child for child in brother.children if child])