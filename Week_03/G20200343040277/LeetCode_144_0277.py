#二叉树遍历
#递归方法
# 144 前序遍历

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
        #print(treeNode.root)#  前序遍历  根  左 右
        midPrint(treeNode.left)
    print(treeNode.root)# 中序遍历  左  根 右
    midPrint(treeNode.right)
    #print(treeNode.root)#  后续遍历  左 根 右
midPrint(A)

