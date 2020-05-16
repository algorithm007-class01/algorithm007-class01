class Solution {
    // 中心拓展法，O(n^2) O(1)
    public int countSubstrings(String s) {
        int n = s.length();
        int ans = 0;
        // 长度为n的字符串有n + n-1个中心，n为n个字符，n-1为n-1个字符之间的空隙。
        for (int i = 0; i < 2*n-1; ++i) {
            // 索引变换，从中心左边转换为数组下标。
            int left = i / 2;
            int right = left + i%2;
            
            while (left >= 0 && right < n && s.charAt(left)== s.charAt(right)) {
                left--;
                right++;
                ans++;
            }
        }
        return ans;
    }
}
// dp：
// class Solution {
//     public int countSubstrings(String s) {
//         int n = s.length();
//         // dp[i][j]：c[i]到c[j]是否为回文串。
//         boolean[][] dp = new boolean[n][n];
//         int ans = 0;
//         // i j 的设定保证了只使用dp数组的上三角，不会出现重复。
//         // 由于dp[i][j]需要用到dp[i+1][j-1]，因此遍历的顺序也要稍微改一下
//         // 采用自左到右，自下到上的遍历顺序。
//         for (int j = 0; j < n; ++j) {
//             for (int i = j; i >= 0; --i) {
//                 if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
//                     dp[i][j] = true;
//                     ans++;
//                 }
//             }
//         }
//         return ans;
//     }
// }
