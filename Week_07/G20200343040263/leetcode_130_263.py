# 从边界出发吧，先把边界上和 O 连通点找到, 把这些变成 B,然后遍历整个 board 把 O 变成 X, 把 B 变成 O
class Solution:
    def solve(self, board: List[List[str]]) -> None:
        if not board:
            return
        row = len(board)
        col = len(board[0])
        def dfs(i,j):
            board[i][j] = 'B'
            for x,y in [(-1,0),(1,0),(0,1),(0,-1)]:
                temp_i = i + x
                temp_j = j + y
                if 1 <= temp_i < row and 1 <= temp_j < col and board[temp_i][temp_j] == '0':
                    dfs(temp_i,temp_j)
        for j in range(col):
            if board[0][j] == '0':
                dfs(0,j)
            if board[row-1][j] == '0':
                dfs(row-1,0)
        for i in range(row):
            if board[i][0] == '0':
                dfs(i,0)
            if board[i][col-1] == '0':
                dfs(i,col-1)
        for i in range(row):
            for j in range(col):
                if board[i][j] == 'o':
                    board[i][j] = 'X'
                if board[i][j] == 'B':
                    board[i][j] = 'O'
class Solution:
    def solve(self, board: List[List[str]]) -> None:
        f = {}
        def find(x):
            f.setdefault(x,x)
            if f[x] != x:
                f[x] = find(f[x])
            return f[x]
        def union(x,y):
            f[find(y) = find(x)
        if not board: 
            return
        row = len(board)
        col = len(board[0])
        dummy = row*col
        for i in range(row):
            for j in range(col):
                if board[i][j] == '0':
                    if i == 0 or i == row -1 or j == 0 or j == col -1:
                        union(i*col+j,dummy)
                    else:
                        for x,y in [(-1,0),(1,0),(0,-1),(0,1)]:
                            if board[i+x][j+y] == '0':
                                union(i*col+j,(i+x)*col+(j+y))
        for i in range(row):
            for j in range(col):
                if find(dummy) == find(i*col+j):
                    board[i][j] = 'O'
                else:
                    board[i][j] = 'X'