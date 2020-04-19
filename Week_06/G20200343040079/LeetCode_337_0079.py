#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/house-robber-iii/
题目描述
337. House Robber III
Medium
The thief has found himself a new place for his thievery again.
There is only one entrance to this area, called the "root."
Besides the root, each house has one and only one parent house. After a tour,
the smart thief realized that "all houses in this place forms a binary tree".
It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.
Example 1:
Input: [3,2,3,null,3,null,1]

     3
    / \
   2   3
    \   \
     3   1
Output: 7
Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.

Example 2:
Input: [3,4,5,1,3,null,1]

     3
    / \
   4   5
  / \   \
 1   3   1
Output: 9
Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
"""

from typing import List


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def rob(self, root: TreeNode) -> int:
        # # 解法1 递归回溯+缓存记忆
        # if not root: return 0
        #
        # def _rob(root):
        #     if not root: return 0
        #
        #     if root in memo: return memo[root]
        #     # 抢
        #     a = root.val + \
        #         (_rob(root.left.left) + _rob(root.left.right) if root.left else 0) + \
        #         (_rob(root.right.left) + _rob(root.right.right) if root.right else 0)
        #     # 不抢
        #     b = _rob(root.left) + _rob(root.right)
        #
        #     memo[root] = max(a, b)
        #     return memo[root]
        #
        # memo = {}
        # ans = _rob(root)
        # return ans

        # 解法2 递归回溯, 一次遍历, 由底向上不用缓存
        if not root: return 0

        def _rob(root):
            if not root: return [0, 0]  # index 0:不抢root, 1:抢root.val
            left = _rob(root.left)
            right = _rob(root.right)
            return [max(left) + max(right), root.val + left[0] + right[0]]
        ans = _rob(root)
        return max(ans)
