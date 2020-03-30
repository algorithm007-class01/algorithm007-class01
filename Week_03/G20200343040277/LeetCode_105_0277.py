"""
105. 从前序与中序遍历序列构造二叉树
递归

"""
class tree_node(object):

    def __init__(self,root=None,left=None,right=None):
        self.left=left
        self.right=right
        self.root=root




    def tree_create(self,pre,inorder):
        if len(inorder) == 0:
            return None
        root = tree_node(pre[0])#gen节点
        mid=inorder.index(pre[0])# 查找跟节点在中序遍历中的位置
        root.left = self.tree_create(pre[1:mid+1] , inorder[:mid])
        root.right = self.tree_create(pre[mid+1:] , inorder[mid+1:])


        return root;

    def printTree(self,root):
        if root is not None:
            if root.left is not None:
                print(str(root.root) + " left:" + str(root.left.root))  #
            if root.right is not None:
                print(str(root.root) + " right: " + str(root.right.root))
            self.printTree(root.left)
            self.printTree(root.right)


if __name__=="__main__":
    pre = [3, 9, 20, 15, 7]
    inorder = [9, 3, 15, 20, 7]
    node = tree_node()
    root = node.tree_create(pre,inorder)
    node.printTree(root)

"""
结果：

3 left:9
3 right: 20
20 left:15
20 right: 7
"""



