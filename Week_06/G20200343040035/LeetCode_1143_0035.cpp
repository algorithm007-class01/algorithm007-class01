#include<iostream>
#include<vector>

using namespace std;

class Solution {
public:
    int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid) {
        if(obstacleGrid.size()==0 || obstacleGrid[0].size()==0)
            return 0;
        int m=obstacleGrid.size();
        int n=obstacleGrid[0].size();
        //犯错点1：使用int 导致报错
        vector<vector<long>> res(m,vector<long>(n));
        if (obstacleGrid[0][0] == 1){
            return 0;
        }
        res[0][0] = 1;
        //犯错点2：边界应为res[i][0] = res[i-1][0]及res[0][i] = res[0][i-1] 不应该直接赋值为1
        for (int i = 1; i < m; i++){
            if (obstacleGrid[i][0] == 0 && obstacleGrid[i-1][0]==0){
                res[i][0] = res[i-1][0];
            }
            else{
                res[i][0] = 0;
            }
        }
        for (int i = 1; i < n; i++){
            if (obstacleGrid[0][i] == 0 && obstacleGrid[0][i-1] == 0){
                res[0][i] = res[0][i-1];
            }
            else{
                res[0][i] = 0;
            }
        }
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                if (obstacleGrid[i][j] == 0){
                    res[i][j] = res[i - 1][j] + res[i][j - 1];
                }
                else{
                    res[i][j] = 0;
                }
            }
        }
        return res[m-1][n-1];
    }
};