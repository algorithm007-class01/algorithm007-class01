# -*- coding: utf-8 -*-


class Node(object):
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children


class Solution(object):

    # 迭代
    def preorder_1(self, root):
        if not root:
            return []

        stack, show = [root], []
        while stack:
            tmp = []
            root = stack.pop(0)
            if root:
                show.append(root.val)

            children = root.children
            for c in children:
                tmp.append(c)
            tmp.extend(stack)
            stack = tmp
        return show

    # 递归
    def preorder_2(self, root):
        rs = []
        if not root:
            return rs

        rs.append(root.val)
        children = root.children
        for c in children:
            rs.extend(self.preorder_2(c))
        return rs
