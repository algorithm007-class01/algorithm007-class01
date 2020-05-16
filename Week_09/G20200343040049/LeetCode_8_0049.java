class Solution {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) return 0;
        int idx = 0;
        int n = str.length();
        int MAX = Integer.MAX_VALUE;
        int MIN = Integer.MIN_VALUE;
        boolean negative = false;

        while (idx < n && str.charAt(idx) == ' ') idx++;
        if (idx == n) return 0;

        if (str.charAt(idx) == '+') {
            idx++;
        } else if (str.charAt(idx) == '-') {
            negative = true;
            idx++;
        }

        int ans = 0;
        int limit = negative ? MIN : -MAX;

        while (idx < n && str.charAt(idx) == '0') idx++;
        while (idx < n && Character.isDigit(str.charAt(idx))) {
            int digit = str.charAt(idx++) - '0';
            // ans = ans*10 - digit，ans是负的，这么做是因为正数中-Integer.MIX_VALUE无法正确表示出来
            if (ans < (limit + digit) / 10)
                return negative ? MIN : MAX;
            ans = ans * 10 - digit;
        }
        return negative ? ans : -ans;
    }
}
