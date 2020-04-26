package week6.lesson12.p4.homework;

/**
 * 647. 回文子串
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * <p>
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abc"
 * 输出: 3
 * 解释: 三个回文子串: "a", "b", "c".
 * 示例 2:
 * <p>
 * 输入: "aaa"
 * 输出: 6
 * 说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
 * 注意:
 * <p>
 * 输入的字符串长度不会超过1000。
 */
public class LeetCode_647_0227 {
    public int countSubstrings(String s) {
        //dp[i][j]表示s[i...j]是否为回文字串。
        boolean[][] dp = new boolean[s.length()][s.length()];
        int ans = 0;
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = true;
            ans++;
        }
        for (int i = 1; i < dp.length; i++)
            if (s.charAt(i - 1) == s.charAt(i)) {
                dp[i - 1][i] = true;
                ans++;
            }
        for (int k = 2; k < s.length(); k++)
            for (int i = k; i < s.length(); i++)
                if (s.charAt(i - k) == s.charAt(i) && dp[i - k + 1][i - 1]) {
                    dp[i - k][i] = true;
                    ans++;
                }
        return ans;
    }
}
