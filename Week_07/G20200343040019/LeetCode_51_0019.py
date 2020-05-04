class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        res = [] 

        def backtrace(num, queen = []):
            if num == 0:
                res.append(queen)
                return
            for i in range(n):
                col = num - 1
                newQ = i
                canadd = True
                for j in range(len(queen)):
                    qcol = n-j-1
                    if qcol == col or queen[j] == newQ  or abs(qcol-col)/abs(queen[j]-newQ)==1:
                        canadd = False
                        break
                if canadd:
                    backtrace(num-1, queen+[newQ])
        backtrace(n)
        board = []
        # cols = [True for _ in range(n)]
        # row = [True for _ in range(n)]
        # dif = [True for _ in range(2*n-1)]
        

        return [["." * i + "Q" + "." * (n - i - 1) for i in r] for r in res]
        # for r in res:
        #     ans = [["." for _ in range(n)] for _ in range(n)]
        #     for [i, j] in r:
        #         ans[i][j] = "Q"
        #         ans[i] = "".join(ans[i])

        #     board.append(ans)                
        # return board