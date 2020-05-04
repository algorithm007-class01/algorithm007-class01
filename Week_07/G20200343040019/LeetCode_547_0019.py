class Union:
    def __init__(self, n):
        self.p  = [i for i in range(n)]
        self.c = n

    def union(self, i,j):
        p1 = self.parent( i )
        p2 = self.parent( j )
        if p1 != p2:
            self.p[p1] = p2
            self.c-=1
        
    def parent(self, i):
        root = i
        while self.p[root] != root:
            root = self.p[root]
        while self.p[i] != i:
            i, self.p[i] = self.p[i], root
        return root

class Solution:
    def findCircleNum(self, M: List[List[int]]) -> int:
        N = len(M)
        u = Union(N)

        for i in range(N):
            for j in range(N):
                if M[i][j] == 1:
                    u.union(i,j)
                    # print(u.p)

        # res = 0
        # for i in u.p:
        #     if (u.parent(i) == i):
        #         res+=1
        
        return u.c

