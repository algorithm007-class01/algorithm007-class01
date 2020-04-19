class Solution:
    def updateBoard(self, board: List[List[str]], click: List[int]) -> List[List[str]]:
        if not board: return []
        i, j = click[0], click[1]
        if board[i][j] == 'M':
            borad[i][j] = 'X'
        self.dfs(board, i, j)
        return board
    def dfs(self, board, i, j):
        if board[i][j] != 'E':
            return
        m = len(board)
        n = len(board[0])
        directions = [(-1,-1),(-1,0),(-1,1),(1,-1),(1,0),(1,1),(0,1),(0,-1)]
        min_count = 0
        for d in directions:
            ni, nj = i + d[0], j + d[1]
            if 0 <= ni < m and 0 <= nj < n and board[ni][nj] == 'M':
                min_count += 1
            if min_count == 0:
                board[i][j] = 'B'
            else:
                board[i][j] = str(min_count) 
                return
            for d in directions:
                if 0 <= ni < m and 0 <= nj < n:
                    self.dfs(board,ni,nj)