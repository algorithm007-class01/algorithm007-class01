//	遇到影响成为回文串的字母时，删除前半串或者后半串的，两个都尝试，然后判断能否构成回文串
class Solution {
public:
    bool validPalindrome(string s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s[i] != s[j]) {
                int i1 = i, j1 = j - 1, i2 = i + 1, j2 = j;
                while (i1 < j1 && s[i1] == s[j1]) {i1++; j1--;}
                while (i2 < j2 && s[i2] == s[j2]) {i2++; j2--;}
                return i1 >= j1 || i2 >= j2;
            }
        }
        return true;
    }
};