#中序遍历，跟节点在中间；左  跟  右
#按照题解，可以思路
#1，递归
#2，栈的迭代

#递归
#

# [94] 二叉树的中序遍历
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
#二叉树遍历
class TreeNode(object):
    def __init__(self,root,left=None,right=None):
        self.root=root
        self.left=left
        self.right=right
A=TreeNode("A")
B=TreeNode("B")
C=TreeNode("C")
D=TreeNode("D")
E=TreeNode("E")
F=TreeNode("F")
G=TreeNode("G")
H=TreeNode("H")
A.left =B
A.right = C
B.left = E
B.right = F
C.left = G
C.right = H
def midPrint(treeNode):
    if treeNode is None:
        return
    else:
        midPrint(treeNode.left)
    print(treeNode.root)#  EBFAGCH
    midPrint(treeNode.right)
midPrint(A)










