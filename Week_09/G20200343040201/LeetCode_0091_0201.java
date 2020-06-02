public class LeetCode_0091_0201 {
    // dp(n) = dp(n-1) + dp(n-2)(可能存在，可能不存在)
    public int numDecodings(String s) {
        if (s.length() == 0) return 0;

        int dp_n_2 = (s.charAt(0) != '0') ? 1 : 0;
        if (s.length() == 1 || dp_n_2 == 0) return dp_n_2;

        int dp_n_1 = 0;
        if (s.charAt(1) != '0') dp_n_1 += dp_n_2;
        if (Integer.parseInt(s.substring(0, 2)) <= 26) dp_n_1++;
        if (s.length() == 2) return dp_n_1;

        int dp = 0;
        for (int i = 2; i < s.length(); i++) {
            dp = 0;
            int oneCharVal = Integer.parseInt(s.substring(i, i + 1));
            int twoCharVal = Integer.parseInt(s.substring(i - 1, i + 1));

            dp += (oneCharVal == 0) ? 0 : dp_n_1;
            dp += (twoCharVal >= 10 && twoCharVal <= 26) ? dp_n_2 : 0;

            dp_n_2 = dp_n_1;
            dp_n_1 = dp;
        }
        return dp;
    }
}
