class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int length = s.length();
        int[] dp = new int[length + 1];
        dp[length] = 1;
        if (s.charAt(length - 1) == '0') {
            dp[length - 1] = 0;
        } else {
            dp[length - 1] = 1;
        }

        for (int i = length - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
                continue;
            }
            if ((s.charAt(i) - '0') * 10 + (s.charAt(i+1) - '0') <= 26)  {
                dp[i] = dp[i + 1] + dp[i + 2];
            } else {
                dp[i] = dp[i + 1];
            }
        }
        return dp[0];
    }
}