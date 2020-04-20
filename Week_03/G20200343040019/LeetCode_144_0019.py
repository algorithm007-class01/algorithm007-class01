# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        # 递归
        # if not root:
        #     return []
        # if root.left is None and root.right is None:
        #     return [root.val]
        # res = []
        # left = self.preorderTraversal(root.left)
        # right = self.preorderTraversal(root.right)
        # res =  [root.val] + left + right
        # return res

        # 迭代
        res = []
        stack = []
        curr = root
        while curr or stack:
            while curr:
                stack.append(curr)
                res.append(curr.val)
                curr = curr.left
            curr = stack.pop()
            curr = curr.right
        return res