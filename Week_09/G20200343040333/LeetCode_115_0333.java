package app;

public class LeetCode_115_0333 {
    class Solution {
        public int numDistinct(String s1, String s2) {
            int m = s1.length(), n = s2.length();
            int[][] f = new int[m + 1][n + 1];
            
            for(int i = 0; i <= m; i++) f[i][0] = 1;
            
            for(int i = 1; i <= m; i++){
                for(int j = 1; j <= n; j++){
                    f[i][j] = f[i - 1][j];
                    if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                        f[i][j] += f[i - 1][j - 1];
                    }
                }
            }
            return f[m][n];   
        }
    }
}