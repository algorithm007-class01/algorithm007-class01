class Solution:
    def totalNQueens(self, n: int) -> int:
        self.count = 0

        def DFS(n, row, cols, pie, na):
            if row >=n:
                self.count+=1
                return 
            
            bits = ((1<<n)-1) & (~(cols|pie|na))

            while bits:
                p = bits & -bits
                bits = bits & (bits-1)
                DFS(n, row+1, (cols|p), (pie|p)<<1, (na|p)>>1)
            
        
        DFS(n,0,0,0,0)
        return self.count