def preorder(self, root: 'Node') -> List[int]:
    res = []

    def get_child(root):
        if not root:
            return
        res.append(root.val)
        for child in root.children:
            get_child(child)

    get_child(root)
    return res

# 下来是递归解法
def preorder(self, root: 'Node') -> List[int]:
    if not root:
        return
    stack = [root, ]
    output = []
    while stack:
        root = stack.pop()
        output.append(root.val)
        stack.extend(root.children[::-1])
    return output
