"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""
from collections import deque
class Solution:
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        if not root:
            return None
        if root.children is None:
            return [[root.val]]
        # 递归
        # res = []
        # for child in root.children:
        #     c = self.levelOrder(child)
        #     if not res:pop
        #         res =  c
        #     else:
        #         for i in range(len(c)):
        #             if i < len(res):
        #                 res[i]= res[i] + c[i]
        #             else:
        #                 res.append(c[i])
        # return [[root.val]]+ res
        # 迭代
        stack = deque()
        res = [[root.val]]
        stack.append(root)
        while stack:
            levelres = []
            l = len(stack)
            for _ in range(l):
                curr = stack.popleft()
                if curr:
                    for item in curr.children:
                        levelres.append(item.val)
                        stack.append(item)
            if levelres:
                res = res + [levelres]
        return res
