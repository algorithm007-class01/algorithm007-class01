class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // dp[i][j] text1 i位置与text2 j 位置 公共子串的最大长度
        if (text1.length() == 0 || text2.length() == 0) {
            return 0;
        }
        int row = text2.length();
        int col = text1.length();
        final int[][] dp = new int[row + 1][col + 1];
        for (int i = 1; i < row + 1; i++) {
            for (int j = 1; j < col + 1; j++) {
                if (text2.charAt(i - 1) == text1.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[row][col];
    }
}