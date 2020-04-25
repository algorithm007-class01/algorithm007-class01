class Solution:
    def findCircleNum(self, M: List[List[int]]) -> int:
        parent = [-1 for _ in range(len(M))]

        def find(parent, i):
            if parent[i] == -1: return i
            return find(parent, parent[i])

        def union(parent, x, y):
            xroot = find(parent, x)
            yroot = find(parent, y)
            if xroot != yroot:
                parent[xroot] = yroot

        def union_find(Matrix):
            for i in range(len(Matrix)):
                for j in range(len(Matrix)):
                    if Matrix[i][j] == 1 and i != j:
                        union(parent, i, j)
            count = 0
            for i in range(len(parent)):
                if parent[i] == -1:
                    count += 1
            return count

        return union_find(M)
