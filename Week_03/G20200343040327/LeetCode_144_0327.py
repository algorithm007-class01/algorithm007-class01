# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        # stack = [root]
        # res = []
        # while stack:
        #     i = stack.pop()
        #     if isinstance(i, TreeNode):
        #         stack.extend([i.right, i.left, i.val])
        #     elif isinstance(i, int):
        #         res.append(i)
        # return res
        res = []
        def helper(root):
            if not root:
                return
            res.append(root.val)
            helper(root.left)
            helper(root.right)
        helper(root)
        return res