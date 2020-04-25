#include <iostream>
#include <vector>
using namespace std;

/**
 * clarification:
 * solution: DP，二维数组
 *      1. 边界条件：dp[i][i]=true
 *         j-i<=2且s[i]==s[j]的时候dp[i][j]=true
 *         j-i>2且s[i]==s[j]且dp[i][j]==true时，dp[i][j]=true
 * 
 * 
 * testcases ['a'] 
*/
class Solution {
   public:
    int countSubstrings(string s) {
         int n = s.length();
        vector<vector<bool>> dp(n, vector<bool>(n, 0));
        int ans = 0;
        for (int i = n-1; i >=0; i--) {
            for (int j = i; j < n; ++j) {
                if (s[i] == s[j] && (j - i <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    ans++;
                }
            }
        }
        return ans;
    }
};