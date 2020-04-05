#给定一个二叉树，返回它的前序遍历
class Solution:
    def preorderTraversal(self,root):
        res = []
        def helper(root):
            if not root:return
            res.append(root.val)
            helper(root.left)
            helper(root.right)
        helper(root)
        return res
#迭代，使用栈
class Solution:
    def preorderTraversal(self,root):
        res = []
        p = root
        stack = []
        while p or stack:
            while p:
                res.append(p.val)
                stack.append(p)
                p = p.left
            p = stack.pop().right
        return res