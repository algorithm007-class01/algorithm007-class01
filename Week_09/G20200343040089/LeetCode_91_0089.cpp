//	动态规划求解
class Solution {
public:
    int numDecodings(string s) {
        if (s.length() == 0) return 0;
        int n = s.length();
        int currMax = 1, prevMax = 1;
        for (int i = n - 1; i >= 0; --i) {
            int tmp = s[i] == '0' ? 0 : currMax;
            if (i < n - 1 && (s[i] == '1' || (s[i] == '2' && s[i+1] < '7'))) tmp += prevMax;
            prevMax = currMax;
            currMax = tmp;
        }
        return currMax;
    }
};