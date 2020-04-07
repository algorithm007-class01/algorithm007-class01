class Solution {
public:
    int robotSim(vector<int>& commands, vector<vector<int>>& obstacles) {
        unordered_set<string> o_set;        
        int x = 0, y = 0, cur = 0, res = 0;
        for(int i=0; i<obstacles.size(); i++){
            o_set.insert(to_string(obstacles[i][0]) + " " + to_string(obstacles[i][1]));
        }

        vector<vector<int>> dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        for(int cmd : commands){
            if(cmd == -2){
                cur = (cur + 3) % 4;
            }else if(cmd == -1){
                cur = (cur + 1) % 4;
            }else{
                for(int i=0; i<cmd; i++){
                    int nx = x + dirs[cur][0];
                    int ny = y + dirs[cur][1];
                    string s = to_string(nx) + " " + to_string(ny);
                    if(o_set.find(s) == o_set.end()){
                        x = nx;
                        y = ny;
                        res = max(res,x*x + y*y);
                    }
                }                
            }
        }
        return res;
    }
};