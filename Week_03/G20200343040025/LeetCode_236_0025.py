"""
236. 二叉树的最近公共祖先
给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def __init__(self):
        self.ans = None  # 初始化节点

    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """

        def find_ancestor(current_node):
            if not current_node:  # 判断是否为空，截止条件
                return False
            left = find_ancestor(current_node.left)
            # 左边递归
            right = find_ancestor(current_node.right)
            # 标记中间
            mid = current_node == p or current_node == q
            if mid + left + right >= 2:  # 截止条件
                self.ans = current_node
            return mid or left or right

        find_ancestor(root)
        return self.ans
