class Union:
    def __init__(self, N):
        self.parents = [i for i in range(N)]
    
    def find(self, node):
        start = node
        while self.parents[node]!=node:
            node = self.parents[node]
        self.parent(start, node)
        return node

    def parent(self, node, parent):
        while self.parents[node] !=parent:
            node, self.parents[node] = self.parents[node], parent

    def union(self, node1, node2):
        p1 = self.find(node1)
        p2 = self.find(node2)
        if p1!=p2:
            self.parent(p1,p2)
    
    def check(self, node1, node2):
        p1 = self.find(node1)
        p2 = self.find(node2)
        return p1==p2

class Solution:
    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if not board or len(board)<=2 or len(board[0])<=2:
            return
        N = len(board)
        M = len(board[0])
        uni = Union(N*M+1)
        root = N*M
        for i in range(N):
            for j in range(M):
                if board[i][j] == 'O':
                    if i==0 or i==N-1 or j==0 or j==M-1:
                        uni.union(i*M+j, root)

                    for ni,nj in ((i-1,j),(i+1,j),(i,j-1),(i,j+1)):
                        if 0<=ni<N and 0<=nj<M and board[ni][nj]=='O':
                            uni.union(i*M+j, ni*M+nj)
        

        for i in range(N):
            for j in range(M):
                if board[i][j] == 'O':
                    if not uni.check(i*M+j, root):
                        board[i][j] = 'X'