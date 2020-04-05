#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

"""
题目描述
429. N-ary Tree Level Order Traversal
Medium
Given an n-ary tree, return the level order traversal of its nodes' values.
Nary-Tree input serialization is represented in their level order traversal,
each group of children is separated by the null value (See examples).

Example 1:
Input: root = [1,null,3,2,4,null,5,6]
Output: [[1],[3,2,4],[5,6]]

Example 2:
Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
Output: [[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
Constraints:
The height of the n-ary tree is less than or equal to 1000
The total number of nodes is between [0, 10^4]
"""

from typing import List


# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children


class Solution:
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        # # 解法1 用队列
        # if not root: return []
        # from collections import deque
        # queue = deque([root])
        # ans = []
        # while queue:
        #     level = []
        #     for _ in range(len(queue)):
        #         node = queue.popleft()
        #         level.append(node.val)
        #         queue.extend(node.children)
        #     ans.append(level)
        # return ans

        # # 解法2 队列 简写
        # if not root: return []
        # queue, ans = [root], []
        # while queue:
        #     ans.append([node.val for node in queue])
        #     queue = [child for node in queue for child in node.children]
        # return ans

        # 解法3 用递归, DFS深度优先遍历
        if not root: return []

        def _dfs(root, level):
            if len(ans) == level: ans.append([])
            ans[level].append(root.val)
            for child in root.children:
                _dfs(child, level + 1)
            return
        ans = []
        _dfs(root, 0)
        return ans

        # 总结: 树遍历相关的问题, 有一个最为直观的解法, 但通常使用递归和迭代都能实现解法。
