#include<iostream>
#include<vector>

using namespace std;

class Solution{
public:
    int uniquePaths(int m, int n) {
        if (m == 1 && n == 1)
            return 1;
        vector<vector<int>> res(m, vector<int>(n));
        for (int i = 0; i < m;i++){
            res[m][0] = 1;
        }
        for (int i = 0; i < n;i++){
            res[0][i] = 1;
        }
        for (int i = 1; i < n;i++){
            for (int j = 1; j < n;j++){
                res[i][j] = res[i - 1][j] + res[i][j - 1];
            }
        }
        return res[n - 1][m - 1];
    }   
};

class Solution{
public:
    int uniquePaths(int m, int n) {
        if (m == 1 && n == 1)
            return 1;
        int **a = new int *[m];
        for (int i = 0; i < m; i++){
            a[i] = new int[n];
        }
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (i == 0 || j == 0){
                    a[i][j] = 1;
                }
                else{
                    a[i][j] = a[i - 1][j] + a[i][j - 1];
                }
            }
        }
        int res = a[m - 1][n - 1];
        for (int i = 0; i < m; i++){
            delete[] a[i];
        }
        delete[] a;
        return res;
    }   
};