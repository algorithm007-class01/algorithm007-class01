#51 N皇后
class Solution(object):
    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """
        def _dfs(queen,xy_sum,xy_diy):
            p=len(queen)
            if p==n:
                result.append(queen)
                return
            for q in range(n):
                if q not in queen and q+p not in xy_sum and p-q not in xy_diy:
                    _dfs(queen+[q],xy_sum+[p+q],xy_diy+[p-q])        


        result=[]
        _dfs([],[],[])
        return [["."*i+"Q"+"."*(n-i-1) for i in sol]for sol in result]
        
