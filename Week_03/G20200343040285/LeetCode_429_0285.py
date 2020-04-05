#
# @lc app=leetcode.cn id=429 lang=python
#
# [429] N叉树的层序遍历
#
# https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/description/
#
# algorithms
# Medium (65.08%)
# Likes:    74
# Dislikes: 0
# Total Accepted:    16.1K
# Total Submissions: 24.7K
# Testcase Example:  '[1,null,3,2,4,null,5,6]'
#
# 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
#
# 例如，给定一个 3叉树 :
#
#
#
#
#
#
#
# 返回其层序遍历:
#
# [
# ⁠    [1],
# ⁠    [3,2,4],
# ⁠    [5,6]
# ]
#
#
#
#
# 说明:
#
#
# 树的深度不会超过 1000。
# 树的节点总数不会超过 5000。
#
#

# @lc code=start
"""
# Definition for a Node.
class Node(object):
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""
from collections import OrderedDict, deque


class Solution(object):
    def levelOrder(self, root):
        """
        :type root: Node
        :rtype: List[List[int]]
        """
        if root == None: return []
        level = 0
        res = []
        q = deque([(root, level)])

        # mapping  = OrderedDict()
        # while q:
        #     node, level = q.popleft()
        #     if level not in mapping:
        #         mapping[level] = [node.val]
        #     else:
        #         mapping[level].append(node.val)
        #     if node.children:
        #         for c in node.children:
        #             # if c:
        #             q.append((c, level+1))
        #     # res.append(mapping[level]) 有重复的
        # for i in sorted(mapping.keys()):
        #     res.append(mapping[i])

        while q:
            node, level = q.popleft()
            if len(res) < level + 1:
                res.append([])
            for i in node.children:
                q.append((i, level + 1))
            res[level].append(node.val)

        return res

# @lc code=end

