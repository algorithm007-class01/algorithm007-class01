#
# @lc app=leetcode.cn id=590 lang=python
#
# [590] N叉树的后序遍历
#
# https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/description/
#
# algorithms
# Easy (72.57%)
# Likes:    57
# Dislikes: 0
# Total Accepted:    18.2K
# Total Submissions: 25.1K
# Testcase Example:  '[1,null,3,2,4,null,5,6]'
#
# 给定一个 N 叉树，返回其节点值的后序遍历。
#
# 例如，给定一个 3叉树 :
#
#
#
#
#
#
#
# 返回其后序遍历: [5,6,3,2,4,1].
#
#
#
# 说明: 递归法很简单，你可以使用迭代法完成此题吗?
#

# @lc code=start
"""
# Definition for a Node.
class Node(object):
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""


class Solution(object):
    def postorder(self, root):
        """
        :type root: Node
        :rtype: List[int]
        """

        if not root:
            return []
        if not root.children:
            return [root.val]
        res = []
        l = [root.val]
        for c in root.children: res += self.postorder(c)
        res += l
        return res

# @lc code=end

