//91. 解码方法

class Solution {
public:
    int numDecodings(string s) {
        if (s[0] == '0') return 0;
        int n = s.size();
        vector<int> dp(n + 1);
        dp[0] = 1, dp[1] = 1;
        for (int i = 1; i < n; ++i) {
            if (s[i] == '0') {
                if (s[i - 1] == '1' || s[i - 1] == '2') {
                    dp[i + 1] = dp[i - 1];
                }
                else return 0;
            }
            else {
                if (s[i - 1] == '1' || (s[i - 1] == '2' && s[i] <= '6')) {
                    dp[i + 1] = dp[i] + dp[i - 1];
                }
                else dp[i + 1] = dp[i];
            }
        }
        return dp[n];
    }
};