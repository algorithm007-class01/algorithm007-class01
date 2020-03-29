def preorderTraversal(self, root: TreeNode) -> List[int]:
    res = []
    def get_val(root):
        if not root:
            return
        res.append(root.val)
        if root.left:
            get_val(root.left)
        if root.right:
            get_val(root.right)
    get_val(root)
    return res

# 递归解法
def preorderTraversal(self, root: TreeNode) -> List[int]:
    if not root:
        return []
    stack = [root]
    output = []
    while stack:
        res = stack.pop()
        output.append(res.val)
        if res.right:
            stack.append(res.right)
        if res.left:
            stack.append(res.left)
    return output
