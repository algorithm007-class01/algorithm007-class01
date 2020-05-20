class Solution {
public:
    string longestPalindrome(string s) {
        int len = s.size();
        if (len < 2) return s;
        int start = 0;
        int max = 0;
        int i = 0;
        while (i < len) {
            int r = i, l = i;
            while (r < len - 1 && s[r] == s[r + 1]) r++;
            i = r + 1;
            while (r < len - 1 && l > 0 && s[r + 1] == s[l - 1]) {
                r++;
                l--;
            }
            int temp_len = r - l + 1;
            if (temp_len > max) {
                start = l;
                max = temp_len;
            }
        }
        return s.substr(start, max);
    }
};
