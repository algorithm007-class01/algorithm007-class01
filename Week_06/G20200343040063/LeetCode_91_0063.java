class Solution {

    // 动态规划解法
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) return 0;

        int len = s.length();
        int[] dp = new int[len+1];
        dp[len] = 1;
        if(s.charAt(len -1) != '0'){
            dp[len-1] = 1;
        }
        for(int i = len - 2 ; i >= 0 ; i-- ){
            char  ch = s.charAt(i);
            if(ch == '0'){
                continue;
            }
            int a = dp[i+1];
            int b = 0;
            int ten = (ch - '0')* 10;
            int one = s.charAt(i+1) - '0';
            if(ten + one <= 26){
                b = dp[i+2];
            }
            dp[i] = a+b;
        }
        return dp[0];
    }
}