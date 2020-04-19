class Solution:
    def updateBoard(self, board: List[List[str]], click: List[int]) -> List[List[str]]:
        n, m = len(board), len(board[0])
        x, y = click[0], click[1]
        if board[x][y] == 'M':
            board[x][y] = 'X'
            return board
        def dfs(board, x , y):
            dx = [1, 1, 1, 0, 0, -1, -1, -1]
            dy = [1, 0, -1, 1, -1, -1, 0, 1]
            mins = 0
            for i in range(8):
                nx, ny = x + dx[i], y + dy[i]
                if 0 <= nx < n and 0<= ny < m:
                    if board[nx][ny] == 'M':
                        mins += 1
            if mins == 0:
                board[x][y] = 'B'
                for i in range(8):
                    nx = x + dx[i]
                    ny = y + dy[i]
                    if 0 <= nx < n and 0<= ny < m:
                        if board[nx][ny] == 'E':
                            dfs(board, nx, ny)
            else:
                board[x][y] = str(mins)
        dfs(board, x, y)
        return board