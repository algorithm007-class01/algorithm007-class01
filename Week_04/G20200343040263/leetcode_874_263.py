class Solution:
    def robotSim(self, commands: List[int], obstacles: List[List[int]]) -> int:
        #(0,1) 前进(1)  (1,0)右转(2)  (0,-1)后退(3)  (-1,0)左转(4)
        dx = [0,1,0,-1]
        dy = [1,0,-1,0]
        i = 0
        distance = 0
        x = 0
        y = 0
        obs_dict = {}
        obstacleSet = set(map(tuple,obstacles))
        for com in commands:
            if com == -2 #(左转):
                i = (i + 3) % 4
            elif com == -1:
                i = (i + 1) % 4
            else:
                for j in range(com):
                    next_x = x + dx[i]
                    next_y = y + dy[i]
                    if (next_x,next_y) in obstacleSet:
                        break
                    x, y =next_x, next_y
                    distance = max(distance, x*x + y*y)
        return distance