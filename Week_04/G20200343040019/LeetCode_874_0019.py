class Solution:
    def robotSim(self, commands: List[int], obstacles: List[List[int]]) -> int:

        dx = [0,1,0,-1]
        dy = [1,0,-1,0]
        t = 0
        obstacles = set(map(tuple,obstacles))
        pos = (0,0)
        res = 0
        newC = [0]
        for c in commands:
            if c>0 and newC[-1]>=0:
                newC[-1]+=c
            else:
                newC.append(c)

        for c in newC:
            if c == -1:
                t= (t+1)%4
            elif c== -2:
                t = (t-1)%4
            else:
                for i in range(c):
                    npos = (pos[0]+dx[t], pos[1]+dy[t])
                    if npos in obstacles:
                        break
                    pos = npos
            res = max(res, pos[0]**2 + pos[1]**2)

        return res
