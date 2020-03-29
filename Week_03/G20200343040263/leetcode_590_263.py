#给定一个n叉树，返回其节点值的后序遍历
#递归法
def postorder(self, root):
    res = []
    if root == None: return res
    def recursion(root, res):
        for child in root.children:
            recusion(child, res)
        res.append(root.val)
    recursion(root, res)
    return res