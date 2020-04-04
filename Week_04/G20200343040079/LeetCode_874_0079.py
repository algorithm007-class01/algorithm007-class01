#! /usr/bin/env python
# coding: utf-8

# 学号：G20200343040079

""" https://leetcode.com/problems/walking-robot-simulation/description/
题目描述
874. Walking Robot Simulation
Easy
A robot on an infinite grid starts at point (0, 0) and faces north.
The robot can receive one of three possible types of commands:

-2: turn left 90 degrees
-1: turn right 90 degrees
1 <= x <= 9: move forward x units
Some of the grid squares are obstacles.

The i-th obstacle is at grid point (obstacles[i][0], obstacles[i][1])
If the robot would try to move onto them, the robot stays on the previous grid square instead
(but still continues following the rest of the route.)
Return the square of the maximum Euclidean distance that the robot will be from the origin.

Example 1:

Input: commands = [4,-1,3], obstacles = []
Output: 25
Explanation: robot will go to (3, 4)
Example 2:
Input: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
Output: 65
Explanation: robot will be stuck at (1, 4) before turning left and going to (1, 8)
Note:
0 <= commands.length <= 10000
0 <= obstacles.length <= 10000
-30000 <= obstacle[i][0] <= 30000
-30000 <= obstacle[i][1] <= 30000
The answer is guaranteed to be less than 2 ^ 31.
"""

from typing import List


class Solution:
    def robotSim(self, commands: List[int], obstacles: List[List[int]]) -> int:
        if not commands: return 0
        obstacles = set([tuple(v) for v in obstacles])

        dx, dy = 0, 1
        x = y = 0
        ans = 0
        for c in commands:
            if c == -2:
                dx, dy = - dy, dx
            elif c == -1:
                dx, dy = dy, - dx
            else:
                for i in range(1, c + 1):
                    nx = dx + x
                    ny = dy + y
                    if (nx, ny) in obstacles:
                        break
                    else:
                        x, y = nx, ny
                ans = max(ans, x * x + y * y)
        return ans
