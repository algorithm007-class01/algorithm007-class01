#include <iostream>
#include <set>
#include <vector>

using namespace std;

/**
 * 题目：模拟行走机器人
 * solution: 使用正常遍历求解，使用set存放障碍点
 * test cases:正常数据commands = [4,-1,3], obstacles = []，有阻碍的数据commands = [4,-1,4,-2,4], obstacles = [[2,4]]
*/

class Solution {
   public:
    int robotSim(vector<int>& commands, vector<vector<int>>& obstacles) {
        // 记录x,y的四个方向
        int dx[4] = {0, 1, 0, -1};
        int dy[4] = {1, 0, -1, 0};
        int x = 0, y = 0, di = 0;

        // 遍历障碍点数组，生成集合，便于查询
        set<pair<int, int>> obstacleSet;
        for (vector<int> obstacle : obstacles)
            obstacleSet.insert(make_pair(obstacle[0], obstacle[1]));

        int ans = 0;
        for (int cmd : commands) {
            if (cmd == -2)
                di = (di + 3) % 4;
            else if (cmd == -1)
                di = (di + 1) % 4;
            else {
                for (int k = 0; k < cmd; ++k) {
                    int nx = x + dx[di];
                    int ny = y + dy[di];
                    // 判断条件，下一步不是障碍点
                    if (obstacleSet.find(make_pair(nx, ny)) == obstacleSet.end()) {
                        x   = nx;
                        y   = ny;
                        ans = fmax(ans, x * x + y * y);
                    } else
                        break;
                }
            }
        }

        return ans;
    }
};