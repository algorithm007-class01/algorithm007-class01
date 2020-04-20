#给定一个 N 叉树，返回其节点值的层序遍历。
# (即从左到右，逐层遍历)
# 广度优先搜索
class Solution:
    def leveOrder(self, root: 'Node'):
        if root is None:
            return []
        queue = [root]
        out = []
        while queue:
            child = []
            node = []
            for item in queue:
                child.append(item.val)
                if item.children:
                    node += item.children
            out.append(child)
            queue = node
        return out