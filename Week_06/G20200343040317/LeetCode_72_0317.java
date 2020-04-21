class Solution {
    public int minDistance(String word1, String word2) {
        if (word1.isEmpty()) {
            return word2.length();
        }
        if (word2.isEmpty()) {
            return word1.length();
        }
        final int row = word2.length();
        final int col = word1.length();
        final int[][] dp = new int[row + 1][col + 1];
        for (int i = 0; i <= col; i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i <= row; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <=row; i++) {
            for (int j = 1; j <=col; j++) {
                if (word1.charAt(j-1) == word2.charAt(i-1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[row ][col ];
    }
}