class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1 == null || text2 == null){
            return 0;
        }
        int rowlen = text1.length();
        int collen = text2.length();
        if(rowlen == 0|| collen == 0){
            return 0;
        }
        char[] char1 = text1.toCharArray();
        char[] char2 = text2.toCharArray();
        int[][] dp = new int[rowlen][collen];
        dp[0][0] = char1[0] == char2[0] ? 1 : 0;

        for(int i = 1;i < rowlen;i ++){
            dp[i][0] = char2[0] == char1[i] ? 1 : dp[i-1][0];
        }
        for(int i = 1; i < collen;i ++){
            dp[0][i] = char1[0] == char2[i] ? 1 : dp[0][i-1];
        }
        for(int i = 1; i < rowlen;i ++){
            for(int j = 1;j < collen;j ++){
                if(char1[i] == char2[j]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[rowlen-1][collen-1];
    }
}