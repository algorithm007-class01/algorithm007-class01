#include<iostream>
#include<algorithm>

using namespace std;

class Solution {
public:
    vector<int> countBits(int num) {
        vector<int> res(num + 1);
        for(int i = 1; i <= num; i++)
        {
            if(i & 1)
            {
                //奇数
                res[i] = res[i - 1] + 1;
            }
            else
            {
                //偶数
                res[i] = res[i >> 1];
            }
        }
        return res;
    }
};