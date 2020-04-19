class Solution {
    public int numDecodings(String s) {
        final int len = s.length();
        if (len == 0)
            throw new IllegalArgumentException("s can't be empty");

        int pre = 1, cur = s.charAt(0) == '0' ? 0 : 1, tmp;
        for (int i = 1; i < len && cur != 0; ++i) {
            tmp = cur;
            if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) <= '6')) {
                if (s.charAt(i) == '0')
                    cur = pre;
                else
                    cur += pre;
            } else if (s.charAt(i) == '0') {
                cur = 0;
            }
            pre = tmp;
        }
        return cur;
    }
}