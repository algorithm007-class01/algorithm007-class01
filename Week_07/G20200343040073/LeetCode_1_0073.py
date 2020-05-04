# 547. 朋友圈
class Solution:
    def findCircleNum(self, M: List[List[int]]) -> int:
        def union(p, i, j) -> int:
            a = parent(p, i)
            b = parent(p, j)
            p[a] = b
        def parent(p, i) -> int:
            a = i
            while p[a] != a:
                a = p[a]
            return a
        p = [i for i in range(len(M))]
        for i in range(len(M)):
            for j in range(len(M[0])):
                if M[i][j] == 1:
                    union(p, i, j)
        print(p)
        return len(set(parent(p, i) for i in range(len(M))))
