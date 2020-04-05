def postorder(self, root: 'Node') -> List[int]:
    res = []

    def get_val(root):
        if not root:
            return
        if not root.children:
            res.append(root.val)
            return
        for child in root.children:
            get_val(child)
        res.append(root.val)

    get_val(root)
    return res

# 递归解法
def postorder(self, root: 'Node') -> List[int]:
    if not root:
        return
    stack = [root, ]
    output = []
    while stack:
        root = stack.pop()
        output.append(root.val)
        stack.extend(root.children[::1])
    output = output[::-1]
    return output
