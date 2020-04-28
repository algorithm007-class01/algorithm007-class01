#212. 单词搜索 II
import collections
END_OF_WORD="#"
dx=[-1,1,0,0]
dy=[0,0,1,-1]
class Solution(object):
    def findWords(self, board, words):
        """
        :type board: List[List[str]]
        :type words: List[str]
        :rtype: List[str]
        """
        
        
        self.result=set()
        if not board:
            return []
        if not words:
            return []
        root=collections.defaultdict()
        for word in words:
            node=root
            for char in word:
                node=node.setdefault(char,collections.defaultdict())
            node[END_OF_WORD]=END_OF_WORD
        self.m,self.n=len(board),len(board[0])
        for i in range(self.m):
            for j in range(self.n):
                if board[i][j] in root:
                    self._dfs(board,i,j,"",root)
        return list(self.result)
    def _dfs(self,board,i,j,curword,curdict):
        curword+=board[i][j]
        curdict=curdict[board[i][j]]
        if END_OF_WORD in curdict:
            self.result.add(curword)
        tmp,board[i][j]=board[i][j],'@'
        for k in range(4):
            x=i+dx[k]
            y=j+dy[k]
            if 0<=x<self.m and 0<=y<self.n and board[x][y]!='@' and board[x][y] in curdict:
                self._dfs(board,x,y,curword,curdict)
        board[i][j]=tmp

