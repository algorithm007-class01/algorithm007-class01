"""
589. N叉树的前序遍历
迭代想法
"""
class n_tree(object):
    def __init__(self,root):
        self.children = []
        self.root=root
    def __str__(self):#相当于tostring
        self.root

A = n_tree("A")
B = n_tree("B")
C = n_tree("C")
D = n_tree("D")
E = n_tree("E")
F = n_tree("F")
G = n_tree("G")
H = n_tree("H")
A.children.append(B)
A.children.append(C)
A.children.append(D)
B.children.append(E)
B.children.append(F)
E.children.append(G)
E.children.append(H)
#前序遍历
def PostOrder(node):
    list = []
    if node is None:
        return list
    iteam=[]
    iteam.append(node)

    while iteam:
        iteams=iteam.pop()  # 表示出栈，弹出栈顶元素
        print(iteams.root)
        list.append(iteams.root)
        if iteams:
            for i in iteams.children[::-1]:
                iteam.append(i)
    print(list)  #  ['A', 'B', 'E', 'G', 'H', 'F', 'C', 'D']

PostOrder(A)










