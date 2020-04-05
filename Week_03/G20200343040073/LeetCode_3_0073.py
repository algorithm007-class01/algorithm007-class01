# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# solution 1
class Solution:
    def print(self, node: TreeNode, p: List[int]):
        if not node: return
        p.append(node.val)
        self.print(node.left,p)
        self.print(node.right,p)
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        result = []
        self.print(root,result)
        return result

# solution 2
class Solution:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        result,temp,cur = [],[],root
        while cur or temp:
            result.append(cur.val)
            if cur.right: temp.append(cur.right)
            if cur.left: temp.append(cur.left)
            cur = temp.pop() if temp else None
        return result
