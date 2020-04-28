#BFS 没有A* 自己没有搞出来预估
class Solution:
    def slidingPuzzle(self, board: List[List[int]]) -> int:
        move = {
            0:[1,3],
            1:[0,2,4],
            2:[1,5],
            3:[0,4],
            4:[1,3,5],
            5:[2,4]
        }

        end = [1,2,3,4,5,0]
        queue = [board[0]+board[1]]
        res = 0
        moved = []
        while queue:
            L = len(queue)
            for _ in range(L):
                curr = queue.pop(0)
                if curr not in moved:
                    moved.append(curr)
                if curr == end:
                    return res
                to_index = curr.index(0)
                for m in move[to_index]:
                    nxt = curr.copy()
                    nxt[m], nxt[to_index] = nxt[to_index], nxt[m]
                    if nxt not in moved:
                        queue.append(nxt)
            res+=1
        
        return -1