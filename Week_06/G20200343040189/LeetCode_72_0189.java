//给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
//
// 你可以对一个单词进行如下三种操作：
// 插入一个字符
// 删除一个字符
// 替换一个字符

// Related Topics 字符串 动态规划

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minDistance(String word1, String word2) {
        // 字符串长度
        int len1 = word1.length(), len2 = word2.length();
        // 定义一个dp table
        int[][] dp = new int[len1+1][len2+1];
        // 如果出现有一个字符串长度为0，那么需要的操作数目如下
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                // 字符串1和字符串2的相同位置字符相同时，无需做任何变化
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    // 字符不相同时，需要做变化
                    // 替换操作dp[i][j] = dp[i-1][j-1] + 1
                    // 插入操作dp[i][j] = dp[i][j-1] + 1
                    // 删除操作dp[i][j] = dp[i-1][j] + 1
                    // 通式如下
                    dp[i][j] = 1 + Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]);
                }
            }
        }
        return dp[len1][len2];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
