//874 - 模拟行走机器人
class Solution {
public:
    struct tmp {
        size_t operator()(const pair<int, int> &pa) const {
            return pa.first * 30000 + pa.second;
        }
    };
    const int dirs[4][2] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    unordered_set<pair<int, int>, tmp>  obs;
    int robotSim(vector<int>& commands, vector<vector<int>>& obstacles) {
        int x0 = 0, y0 = 0, dir = 0, x, y;
        long res = 0, val;
        for (int i = 0; i < obstacles.size(); i++) {
            obs.insert({obstacles[i][0], obstacles[i][1]});
        }
        for (int i = 0; i < commands.size(); i++) {
            if (commands[i] == -1) {
                dir = (dir + 1) % 4;
            } else if (commands[i] == -2) {
                dir = (dir + 3) % 4;
            } else {
                for (int j = 0; j < commands[i]; j++) {
                    x = x0 + dirs[dir][0];
                    y = y0 + dirs[dir][1];
                    if (obs.count({x, y})) break;
                    x0 = x;
                    y0 = y;
                    val = x0*x0 + y0*y0;
                    res = max(res, val);
                }
            }
        }
        return res;
    }
};