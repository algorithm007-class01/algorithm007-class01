# from collections import defaultdict
class Solution:
    def maxSumSubmatrix(self, matrix: List[List[int]], k: int) -> int:
        if not matrix:
            return 0


        def dpmax(row, k):
            res = -sys.maxsize
            curr = 0
            for i in row:
                if curr<0:
                    curr = i
                else:
                    curr += i
                res = max(res, curr)
            if res<=k:
                return res
            res = -sys.maxsize
            for i in range(len(row)):
                c = 0
                for j in range(i,len(row)):
                    c+=row[j]
                    if res< c <=k:
                        res = c
                    if res == k:
                        return res
                        
            return res 

        res = -sys.maxsize
        N = len(matrix)
        M = len(matrix[0])
        for a in range(M):
            row = [0 for _ in range(N)]
            for j in range(a,M):
                for i in range(N):
                    row[i]+=matrix[i][j]
                res = max(res, dpmax(row, k))


        return  res