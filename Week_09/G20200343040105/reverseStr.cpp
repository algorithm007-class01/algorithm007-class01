//541. 反转字符串 II

class Solution {
public:
    string reverseStr(string s, int k) {
        bool flag = false;
        int n = 0;
        while(n < s.length()){
            if(!flag) reverse(s.begin() + n, min(s.end(), s.begin() + n + k));
            n += k, flag = !flag;
        }
        return s;
    }
};