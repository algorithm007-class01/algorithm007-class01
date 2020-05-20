//一条包含字母 A-Z 的消息通过以下方式进行了编码：
//
// 'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
//
//
// 给定一个只包含数字的非空字符串，请计算解码方法的总数。
//
//
// Related Topics 字符串 动态规划


//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int numDecodings(String s) {
        // 判断边界条件
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        // 构造DP table
        int[] dp = new int[len+1];
        dp[0] = 1;
        // 非零个位数必然合法
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        // 对整个字符串进行遍历
        for (int i = 2; i <= len; i++) {
            // 一位数
            int one = Integer.parseInt(s.substring(i - 1, i));
            if (one != 0) {
                dp[i] = dp[i-1];
            }
            if (s.charAt(i - 2) == '0') {
                continue;
            }
            // 两位数
            int two = Integer.parseInt(s.substring(i - 2, i));
            if (two <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[len];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
