"""
n叉树的后续遍历
590. N叉树的后序遍历
使用迭代方法
"""

class n_tree(object):
    def __init__(self,root,):
        self.root=root
        self.children=[]
    def __str__(self):#相当于java的tostring
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

# 后续遍历
def houXu(node):
    if node is None:
        return
    stack = [node,]
    out = []
    while stack:
        output = stack.pop()
        if output is not None:
            out.append(output.root)
        for c in output.children:
            stack.append(c)
    print(out[::-1])#['G', 'H', 'E', 'F', 'B', 'C', 'D', 'A']

houXu(A)