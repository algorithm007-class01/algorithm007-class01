from typing import List
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        list = []
        if root is None:                          #基准条件
            return []
        list.append(root.val)                     #添加根节点
        list += self. preorderTraversal(root.left) #先把左节点加入
        list += self. preorderTraversal(root.right)#添加右节点
        return list
##############################调用函数############################
node1 = TreeNode(10)
node2 = TreeNode(2)
node3 = TreeNode(3)
node4 = TreeNode(4)
node5 = TreeNode(7)
node1.left = node2
node1.right = node3
node2.left = node4
node2.right = node5

res = Solution().preorderTraversal(node1)
print(res)
