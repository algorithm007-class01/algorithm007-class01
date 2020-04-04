# -*- coding: utf-8 -*-


class Node(object):
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children


class Solution(object):

    # 递归
    def postorder_1(self, root):
        """
        :type root: Node
        :rtype: List[int]
        """
        rs = []
        if not root:
            return rs

        for c in root.children:
            rs.extend(self.postorder_1(c))
        rs.append(root.val)

        return rs

    # 迭代
    def postorder_2(self, root):
        if not root:
            return []

        stack, show = [root], []
        while stack:
            root = stack.pop()
            if root:
                show.append(root.val)

            children = root.children
            for c in children:
                stack.append(c)

        return show[::-1]
