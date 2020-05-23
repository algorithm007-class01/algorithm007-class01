//	逐个翻转单词
class Solution {
public:
    string reverseWords(string s) {
        int pos = 0;
        for (int end = 0; end < s.size(); ++end) {
            if (s[end] == ' ') {
                reverse(s.begin() + pos, s.begin() + end);
                end++;
                pos = end;
            }
        }
        reverse(s.begin() + pos, s.end());
        return s;
    }
};