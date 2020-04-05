#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/validate-binary-search-tree/
题目描述
98. Validate Binary Search Tree
Medium
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:
The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

Example 1:
    2
   / \
  1   3

Input: [2,1,3]
Output: true

Example 2:
    5
   / \
  1   4
     / \
    3   6
Input: [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
"""


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        # # 解法1 递归写法, 边递归, 边获取子树的最大、最小值
        # # 根据二叉搜索数的定义来判断
        # if not root: return True
        # def _valid(root):
        #     if not root: return True, None, None
        #     flag, lmax, lmin = _valid(root.left)
        #     if not flag: return False, None, None
        #     flag, rmax, rmin = _valid(root.right)
        #     if not flag: return False, None, None
        #
        #     if lmax is not None and root.val <= lmax: return False, None, None
        #     if rmin is not None and root.val >= rmin: return False, None, None
        #     return True, rmax if rmax is not None else root.val, lmin if lmin is not None else root.val
        #
        # flag, mmax, mmin = _valid(root)
        # return flag

        # # 解法1.2 递归实现判断
        # # 根据二叉搜索数的定义来判断
        # if not root: return True
        # def _valid(root, mmin, mmax):
        #     if not root: return True
        #     if not (mmin < root.val < mmax): return False
        #
        #     if not _valid(root.left, mmin, root.val): return False
        #     if not _valid(root.right, root.val, mmax): return False
        #     return True
        # return _valid(root, float('-inf'), float('+inf'))

        # # 解法2 中序遍历二叉树, 判断是否是升序
        # if not root: return True
        # last = None
        # def _traversal(root):
        #     if not root: return True
        #     nonlocal last
        #     if not _traversal(root.left): return False
        #     if last is not None and root.val <= last: return False
        #     last = root.val
        #     if not _traversal(root.right): return False
        #     return True
        # flag = _traversal(root)
        # return flag

        # # 解法2.1 优化中序遍历方式, 判断是否是升序
        # if not root: return True
        # flag = self.isValidBST(root.left)
        # if not flag: return False
        # if self.last is not None and root.val <= self.last: return False
        # self.last = root.val
        # flag = self.isValidBST(root.right)
        # return flag

        # # 解法3 用迭代实现中序遍历, 判断是否是升序
        # if not root: return True
        # stack = []
        # cur = root
        # last = None
        # while cur or stack:
        #     while cur:
        #         stack.append(cur)
        #         cur = cur.left
        #     cur = stack.pop()
        #     if last is not None and cur.val <= last: return False
        #     last = cur.val
        #     cur = cur.right
        # return True

        # 解法4 中序遍历+排序
        if not root: return True
        l = []
        def _traversal(root):
            if not root: return
            _traversal(root.left)
            l.append(root.val)
            _traversal(root.right)
            return

        _traversal(root)
        for i in range(len(l) - 1):
            if l[i] >= l[i + 1]: return False
        return True
