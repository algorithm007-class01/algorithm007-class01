class Solution {
    public String reverseStr(String s, int k) {

        if (s.length() > 2 * k) {
            return reverse(s.substring(0, k)) + s.substring(k, 2 * k) + reverseStr(s.substring(2 * k), k);
        }
        if (s.length() > k && s.length() <= 2 * k) {
            return reverse(s.substring(0, k)) + s.substring(k);
        }
        if (s.length() <= k && s.length() > 0) {
            return reverse(s);
        }
        return "";
    }

    public String reverse(String str) {
        if (str.length() <= 1) {
            return str;
        }
        int begin = 0;
        int end = str.length() - 1;
        char[] chs = str.toCharArray();
        while (begin < end) {
            char ch = chs[begin];
            chs[begin++] = chs[end];
            chs[end--] = ch;
        }
        return new String(chs);
    }

}