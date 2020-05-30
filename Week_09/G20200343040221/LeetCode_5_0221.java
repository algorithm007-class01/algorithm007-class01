//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划

package leetcode.editor.cn;

// 5. 最长回文子串
public class LongestPalindromicSubstring_5 {

    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring_5().new Solution();
        System.out.println(solution.longestPalindrome("babad"));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 动态规划: S[i, j] = S[i + 1, j - 1] && s[i] == s[j]
    public String longestPalindrome(String s) {
        int length = s.length();
        if (length < 2) {
            return s;
        }
        int left = 0;
        int right = 0;
        boolean[][] dp = new boolean[length][length];
        for (int i = length - 1; i >= 0; i--) {
            for (int j = i; j < length; j++) {
                if (s.charAt(i) == s.charAt(j) && (i == j || i + 1 == j || dp[i + 1][j - 1])) {
                    dp[i][j] = true;

                    if (j - i > right - left) {
                        right = j;
                        left = i;
                    }
                }
            }
        }
        return s.substring(left, right + 1);
    }

    // 中心扩展法
    private int left = 0;
    private int maxLength = 1;
    public String longestPalindrome1(String s) {
        if (s.length() < 2) {
            return s;
        }
        for (int i = 1; i < s.length(); i++) {
            resolvePalindrome(s, i - 1, i + 1);
            resolvePalindrome(s, i - 1, i);
        }
        return s.substring(left, left + maxLength);
    }
    private void resolvePalindrome(String str, int left, int right) {
        int length = str.length() - 1;
        if (left < 0 || right > length || str.charAt(left) != str.charAt(right)) {
            return;
        }
        while (str.charAt(left) == str.charAt(right)) {
            if (left == 0 || right == length) {
                break;
            }
            if (str.charAt(left - 1) != str.charAt(right + 1)) {
                break;
            }
            left--;
            right++;
        }
        int len = right - left + 1;
        if (len > this.maxLength) {
            this.maxLength = len;
            this.left = left;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
