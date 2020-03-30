# -*- coding: utf-8 -*-


class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):

    # 递归
    def preorderTraversal_1(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        rs = []
        if root:
            rs.append(root.val)
            rs.extend(self.preorderTraversal_1(root.left))
            rs.extend(self.preorderTraversal_1(root.right))
        else:
            return rs
        return rs

    # 迭代
    def preorderTraversal_2(self, root):
        if not root:
            return []

        stack, show = [root], []
        while stack:
            tmp = []
            root = stack.pop(0)
            if root:
                show.append(root.val)

            if root.left:
                tmp.append(root.left)
            if root.right:
                tmp.append(root.right)

            tmp.extend(stack)
            stack = tmp

        return show
