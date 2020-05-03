class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        if n<1:
            return []

        res = []

        def DFS(n, row, cols, pie, na, data=[] ):
            if row >= n:
                res.append(data)
                return 

            bits = ((1 << n) - 1) & ( ~( cols | pie | na )) 

            while bits:
                p = bits & -bits
                i = int(math.log(p,2))
                c = "."*(n-i-1)+"Q"+"."*i
                bits = bits &(bits-1)
                DFS(n, row+1, cols|p, (pie|p)<<1, (na|p)>>1, data+[c] )

        DFS(n, 0,0,0,0)

        return res