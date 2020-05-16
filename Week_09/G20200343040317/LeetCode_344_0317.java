class Solution {
    public void reverseString(char[] s) {
        if (s.length <= 1) {
            return;
        }
        int begin = 0;
        int end = s.length - 1;
        while (begin < end) {
            char ch = s[begin];
            s[begin++] = s[end];
            s[end--] = ch;
        }
    }
}