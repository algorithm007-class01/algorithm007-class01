class Solution:
    def updateBoard(self, board: List[List[str]], click: List[int]) -> List[List[str]]:
        def get(i: int, j: int, wide: int, height: int) -> str:
            if i >= 0 and i < wide and j >= 0 and j < height:
                return board[i][j]
            else:
                return None
        def touch(i: int, j: int, wide: int, height: int):
            if [i, j] in touched: return
            if board[i][j] == 'M':
                board[i][j] = 'X'
                touched.append([i,j])
                return
            mcount = 0
            trackList = []
            nearList = [[i-1,j-1],[i-1,j],[i-1,j+1],[i,j-1],[i,j+1],[i+1,j-1],[i+1,j],[i+1,j+1]]
            if board[i][j] == 'E':
                for n in nearList:
                    b = get(n[0], n[1], wide, height)
                    mcount += 1 if b == 'M' else 0
                    if b == 'E': trackList.append([n[0], n[1]])
            board[i][j] = str(mcount) if mcount > 0 else 'B'
            touched.append([i, j])
            if mcount == 0:
                for t in trackList:
                    touch(t[0], t[1], wide, height)
        if not click or not board: return board
        touched = []
        touch(click[0], click[1], len(board), len(board[0]))
        return board
