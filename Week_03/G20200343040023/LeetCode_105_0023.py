# -*- coding: utf-8 -*-


class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):

    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """
        if not preorder and not inorder:
            return None

        root = TreeNode(preorder[0])
        mid_inx = inorder.index(preorder[0])

        root.left = self.buildTree(preorder[1:mid_inx+1], inorder[:mid_inx])
        root.right = self.buildTree(preorder[mid_inx+1:], inorder[mid_inx+1:])

        return root
