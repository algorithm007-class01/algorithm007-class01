public class LeetCode_91_0201 {
    /**
     * 加入第n个字符，解码方式有dp(n)种。
     *
     * dp(n) = dp(n-1) + dp(n-2)， 这就是这道题的状态转移方程
     *
     * 这道题有个坑在于 0 的处理。
     * 因为0的问题，提交错了几次
     */
    public int numDecodings(String s) {
        // 处理0个字符的情况
        if (s == null || s.length() == 0) return 0;

        // 处理第一个字符
        int dp_n_2 = (s.charAt(0) != '0') ? 1 : 0;
        if (s.length() == 1 || dp_n_2 == 0) return dp_n_2;

        // 处理第二个字符
        int dp_n_1 = 0;
        if (s.charAt(1) != '0') dp_n_1 += dp_n_2;
        if (Integer.valueOf(s.substring(0, 2)) <= 26) dp_n_1++;
        if (s.length() == 2) return dp_n_1;

        // 开始做DP递推
        int dp = 0;
        for (int i = 2; i < s.length(); i++) {
            dp = 0;
            int oneCharVal = Integer.valueOf(s.substring(i, i + 1));
            int twoCharVal = Integer.valueOf(s.substring(i - 1, i + 1));

            dp += (oneCharVal == 0) ? 0 : dp_n_1;
            dp += (twoCharVal >= 10 && twoCharVal <= 26) ? dp_n_2 : 0;

            dp_n_2 = dp_n_1;
            dp_n_1 = dp;
        }
        return dp;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode_91_0201().numDecodings("1231"));
    }

}
