class Solution {
public:
    int robotSim(vector<int>& commands, vector<vector<int>>& obstacles) {
        set<pair<int, int>> obs_str;
        for(auto& ob: obstacles) {
            obs_str.insert(pair<int,int>(ob[0], ob[1]));
        }
        // 按照上右下左，顺时针方向.
        vector<vector<int>> dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int direction = 0, x = 0, y = 0, result = 0;
        for(auto& command: commands) {
            if(command == -1) { // 向右转90度
                direction = (direction + 1) % 4; // 顺时针
            } else if(command == -2) { // 向左转90度
                direction = (direction + 3) % 4;
            } else { // 向前移动x个单位长度，围绕x,y位置进行上下左右方向探测.
                    for(int i = 0; i < command; i++) {
                        int nx = x + dirs[direction][0];
                        int ny = y + dirs[direction][1];
                        if(obs_str.find(make_pair(nx, ny)) == obs_str.end()) { // 探测的位置上没有障碍物，则更新坐标.
                            x = nx;
                            y = ny;
                            // 更新距离.
                            result = max(result, x*x + y * y);
                        }
                    }
            }  
        }
        return result;
    }
};
