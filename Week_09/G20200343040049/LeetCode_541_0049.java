class Solution {
    public String reverseStr(String s, int k) {
        char[] str = s.toCharArray();
        int n = s.length();
        if (n <= 1) return s;

        int start = 0;
        while (start < n) {
            int end = Math.min(start + k - 1, n - 1);
            reverse(str, start, end);
            start += 2 * k;
        }
        return String.valueOf(str);
    }

    public void reverse(char[] str, int l, int r) {
        while (l < r) {
            char temp = str[l];
            str[l++] = str[r];
            str[r--] = temp;
        }
    }
}