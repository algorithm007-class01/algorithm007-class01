# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def __init__(self):
        self.ans = None
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        self.search(root, [p,q])
        return self.ans
    def search(self, node, nList: List) -> bool:
        if not node: return False
        selfCon = False
        if node in nList: selfCon = True
        leftCon = self.search(node.left, nList)
        rightCon = self.search(node.right, nList)

        if selfCon + leftCon + rightCon >= 2:
            self.ans = node
        return selfCon or leftCon or rightCon
