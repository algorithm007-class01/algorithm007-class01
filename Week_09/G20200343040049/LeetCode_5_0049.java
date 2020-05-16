// 中心扩散法
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        int n = s.length();
        int maxLen = 0, maxLeft = -1;

        for (int i = 0; i < 2*n-1; ++i) {
            int left = i / 2;
            int right = left + i % 2;

            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                if (maxLen < right - left + 1) {
                    maxLen = right - left + 1;
                    maxLeft = left;
                }
                --left;
                ++right;
            }
        }
        return s.substring(maxLeft, maxLeft + maxLen);
    }
}

// dp
// class Solution {
//     public String longestPalindrome(String s) {
//         if (s.length() == 0) return s;

//         int n = s.length();
//         int[][] dp = new int[n][n];
//         int maxLen = 0, maxLeft = -1;

//         for (int j = 0; j < n; ++j) {
//             for (int i = j; i >= 0; --i) {
//                 if (s.charAt(i) == s.charAt(j)) {
//                     if (j - i < 2 || dp[i + 1][j - 1] == 1) {
//                         dp[i][j] = 1;
//                         if (maxLen < j - i + 1) {
//                             maxLen = j - i + 1;
//                             maxLeft = i;
//                         }
//                     }
//                 }
//             }
//         }
//         return s.substring(maxLeft, maxLeft + maxLen);
//     }
// }