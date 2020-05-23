//	直接翻转每个2k字符块的前k个字符，不足k个则全部翻转
class Solution {
public:
    string reverseStr(string s, int k) {
        for (int start = 0; start < s.length(); start += 2 * k) {
            int i = start;
            int l = start + k - 1, r = s.length() - 1;
            int j = min(l, r);
            while (i < j) {
                char tmp = s[i];
                s[i++] = s[j];
                s[j--] = tmp;
            }
        }
        return s;
    }
};