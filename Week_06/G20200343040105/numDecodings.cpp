//91. 解码方法

//思路：分情况讨论
//若s[i] = '0': 
//      若s[i - 1] = '1' or '2', dp[i + 1] = dp[i - 1],否则return 0
//若s[i - 1] = '1':
//      则dp[i + 1] = dp[i] + dp[i - 1]
//若s[i - 1] = '2' and s[i] <= '6':
//      则dp[i + 1] = d[i] +dp[i - 1]
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

空间复杂度从O(n)-->O(1)
class Solution {
public:
    int numDecodings(string s) {
        if (s[0] == '0') return 0;
        int pre = 1, curr = 1;    //dp[-1] = dp[0] = 1
        for (int i = 1; i < s.size(); i++) {
            int tmp = curr;
            if (s[i] == '0')
                if (s[i - 1] == '1' || s[i - 1] == '2') curr = pre;
                else return 0;
            else if (s[i - 1] == '1' || (s[i - 1] == '2' && s[i] >= '1' && s[i] <= '6'))
                curr += pre;
            pre = tmp;
        }
        return curr;
    }
};