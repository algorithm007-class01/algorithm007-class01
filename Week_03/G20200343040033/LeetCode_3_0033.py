from typing import List
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children

class Solution:
    def postorder(self, root: Node) -> List[int]:
        list = []
        if not root:                          #基准条件
            return []
        for node in root.children:                #添加子节点
            list+=self.postorder(node)
        list.append(root.val)                     #添加根节点 
        return list
##############################调用函数############################
node1 = Node(10)
node2 = Node(2)
node3 = Node(3)
node4 = Node(4)
node5 = Node(7)
node1.children=[node2,node3,node4]  
node2.children = [node5]

res = Solution().postorder(node1)
print(res)
