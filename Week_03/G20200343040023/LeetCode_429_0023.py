# -*- coding: utf-8 -*-


# Definition for a Node.
class Node(object):
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children


class Solution(object):
    def levelOrder(self, root):
        rs = []
        if not root:
            return rs

        current_list = [root]
        while current_list:
            tmp = []
            next_list = []
            for c in current_list:
                tmp.append(c.val)
                next_list.extend(c.children)
            rs.append(tmp)
            current_list = next_list
        return rs
