class Solution {
    public String reverseStr(String s, int k) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        for (int i = 0; i < n; i += 2 * k) {
            int start = i, end = Math.min(i + k - 1, n - 1);
            while (start < end) {
                char tmp = cs[start];
                cs[start++] = cs[end];
                cs[end--] = tmp;
            }
        }
        return new String(cs);
    }
}