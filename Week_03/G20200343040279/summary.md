# 第三周总结

## 树 二叉树 二叉搜索树
### 三种遍历方式
    前序遍历
            <!--
                def preorder(self, root):
                    if root:
                        self.traverse_path(root.val)
                        self.preorder(root.left)
                        self.preorder(root.right)
            -->
    中序遍历
            <!--
                def inorder(self, root):
                    if root:
                        self.inorder(root.left)
                        self.traverse_path(root.val)
                        self.inorder(root.right)
            -->
    后序遍历
            <!--
                def postorder(self, root):
                    if root:
                        self.postorder(root.left)
                        self.postorder(root.right)
                        self.traverse_path(root.val)
            -->

## 堆和二叉堆 图


## 泛型递归 树的递归


## 分治算法 回溯算法