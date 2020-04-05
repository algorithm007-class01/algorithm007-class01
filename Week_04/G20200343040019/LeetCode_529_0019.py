class Solution:
    def updateBoard(self, board: List[List[str]], click: List[int]) -> List[List[str]]:
        i, j = click

        if board[i][j] in ["X","M"]:
            board[i][j] = "X"
            return board
        if board[i][j] == "B" or board[i][j] in string.digits:
            return board
        
        queue = [click]

        def sumNum(i,j):
            res = 0
            for m in range(-1,2):
                for n in range(-1,2):
                    x, y = i+m, j+n
                    if x<0 or y<0 or x>=len(board) or y>=len(board[0]) or (x == i and y ==j):
                        continue
                    if board[x][y]=='M':
                        res+=1
            return res

        num = sumNum(i,j)
        board[i][j] = 'B' if num==0 else "%d"%num
        if num != 0:
            return board
        while queue:
            L = len(queue)
            nextE = set()
            for _ in range(L):
                i,j = queue.pop(0)
                num = sumNum(i,j)
                if num == 0:
                    board[i][j] = 'B'
                    for m in range(-1,2):
                        for n in range(-1,2):
                            x, y = i+m, j+n
                            if x<0 or y<0 or x>=len(board) or y>=len(board[0]) or (x == i and y ==j):
                                continue
                            if board[x][y] == 'E' :
                                nextE.add((x,y))            
                else:
                    board[i][j] = "%d"%num
            queue = list(nextE)

    
        return board