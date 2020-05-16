#52.N皇后||
class Solution(object):
    def totalNQueens(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n<1:

            return []
        self.count=0
        self.dfs(n,0,0,0,0)
        return self.count

    def dfs(self,n,row,cols,pie,na):
        if row>=n:
            self.count+=1
            return
        bits=~(cols|pie|na)&((1<<n)-1)#得到当前所有的空位
        while bits:
            p=bits&-bits#得到最右位的1
            bits=bits&(bits-1)#将最右位的1占上
            self.dfs(n,row+1,cols|p,(pie|p)<<1,(na|p)>>1)
