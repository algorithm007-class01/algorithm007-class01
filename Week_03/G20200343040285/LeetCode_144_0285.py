#
# @lc app=leetcode.cn id=144 lang=python
#
# [144] 二叉树的前序遍历
#
# https://leetcode-cn.com/problems/binary-tree-preorder-traversal/description/
#
# algorithms
# Medium (64.64%)
# Likes:    227
# Dislikes: 0
# Total Accepted:    81.8K
# Total Submissions: 126.3K
# Testcase Example:  '[1,null,2,3]'
#
# 给定一个二叉树，返回它的 前序 遍历。
#
# 示例:
#
# 输入: [1,null,2,3]
# ⁠  1
# ⁠   \
# ⁠    2
# ⁠   /
# ⁠  3
#
# 输出: [1,2,3]
#
#
# 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
#
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def preorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        res = []
        stack = [(root, False)]

        while stack:
            node, visited = stack.pop()
            if node:
                if visited:
                    res.append((node.val))
                else:
                    stack.append((node.right, False))
                    stack.append((node.left, False))
                    stack.append((node, True))
        return res
# @lc code=end

