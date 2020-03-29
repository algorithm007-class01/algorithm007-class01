#给定一个n叉树，返回其节点值的前序遍历
#递归方法解决问题
class Solution:
    def preorder(self, root: 'Node'):
        if root is None:
            return []
        list = []
        list.append(root.val)
        if root.children:
            for item in root.children:
                list += self.preorder(item)
        return list
#非递归的方法解决问题
class Solution:
    def preorder(self, root:'Node') -> List[int]:
        if root is None:
            return []
        stack = [root]
        out = []
        while stack:
            temp = stack.pop()
            out.append(temp.val)
            if temp.children:
                for item in temp.children[::-1]:
                    stack.append(item)
        return out