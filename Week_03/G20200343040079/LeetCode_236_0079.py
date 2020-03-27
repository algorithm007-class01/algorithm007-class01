#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
题目描述
236. Lowest Common Ancestor of a Binary Tree
Medium
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined
between two nodes p and q as the lowest node in T that has both p and q as descendants
(where we allow a node to be a descendant of itself).”

Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]
Example 1:
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.
Example 2:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.

Note:
All of the nodes' values will be unique.
p and q are different and both values will exist in the binary tree.
"""


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        # # 解法1 递归实现, find_p_or_q
        # if not root or root == p or root == q: return root
        # left = self.lowestCommonAncestor(root.left, p, q)
        # right = self.lowestCommonAncestor(root.right, p, q)
        # if left and right: return root
        # return left or right

        # # 解法2 DFS寻找p、q的路径, 较慢
        # if not root or root in (p, q): return root
        #
        # def _gen_path(root, node, cur_path):
        #     if not root: return
        #     if root == node: return cur_path + [root]
        #
        #     path = _gen_path(root.left, node, cur_path + [root])
        #     if path: return path
        #     path = _gen_path(root.right, node, cur_path + [root])
        #     if path: return path
        #     return
        #
        # p_path = _gen_path(root, p, [])
        # q_path = _gen_path(root, q, [])
        # if not p_path or not q_path: return
        # common = None
        # for i in range(min(len(p_path), len(q_path))):
        #     if p_path[i] == q_path[i]: common = p_path[i]
        #     else:break
        # return common

        # 解法3 一次DFS遍历, 寻找p、q的路径
        if not root or root in (p, q): return root

        def _gen_path(root, cur_path):
            if not root: return
            nonlocal p_path, q_path
            if root == p: p_path = (cur_path + [root])
            if root == q: q_path = (cur_path + [root])
            if p_path and q_path: return

            _gen_path(root.left, cur_path + [root])
            _gen_path(root.right, cur_path + [root])
            return

        p_path, q_path = [], []
        _gen_path(root, [])
        if not p_path or not q_path: return
        common = None
        for i in range(min(len(p_path), len(q_path))):
            if p_path[i] == q_path[i]: common = p_path[i]
            else:break
        return common
