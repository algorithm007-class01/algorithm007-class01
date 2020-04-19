class Solution:
    def robotSim(self, commands: List[int], obstacles: List[List[int]]) -> int:
        directions = {'up':{0:[0,1], -1:'right', -2:'left'},
                      'down':{0:[0,-1], -1:'left', -2:'right'},
                      'left':{0:[-1,0], -1:'up', -2:'down'},
                      'right':{0:[1,0], -1:'down', -2:'up'}
                      }
        obstacles = set(map(tuple, obstacles))
        curDir = 'up'
        cord = [0, 0]
        res = 0
        for cmd in commands:
            if cmd < 0:
                curDir = directions[curDir][cmd]
            else:
                for i in range(1, cmd+1):
                    tmp_x, tmp_y = cord[0], cord[1]
                    tmp_x += directions[curDir][0][0]
                    tmp_y += directions[curDir][0][1]
                    if (tmp_x, tmp_y) in obstacles:
                        break
                    cord = [tmp_x, tmp_y]
                res = max(res, cord[0]**2+cord[1]**2)
        return res 