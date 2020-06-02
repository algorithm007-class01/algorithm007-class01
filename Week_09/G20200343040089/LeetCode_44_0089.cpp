//  回溯解法
class Solution {
public:
    bool isMatch(string s, string p) {
        int m = s.length(), n = p.length();
        int i = 0, j = 0, asterisk = -1, match;
        while (i < m) {
            if (j < n && p[j] == '*') {
                match = i; 
                asterisk = j++;
            } else if (j < n && (s[i] == p[j] || p[j] == '?')) {
                i++; 
                j++;
            } else if (asterisk >= 0) {
                i = ++match;
                j = asterisk + 1;
            } else {
                return false;
            }
        }
        while (j < n && p[j] == '*') j++;
        return j == n;
    }
};