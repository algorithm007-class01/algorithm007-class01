//给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。 
//
// 示例 1: 
//
// 
//输入: "abc"
//输出: 3
//解释: 三个回文子串: "a", "b", "c".
// 
//
// 示例 2: 
//
// 
//输入: "aaa"
//输出: 6
//说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
// 
//
// 注意: 
//
// 
// 输入的字符串长度不会超过1000。 
// 
// Related Topics 字符串 动态规划

package leetcode.editor.cn;

public class PalindromicSubstrings_647 {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 动态规划
    // https://leetcode-cn.com/problems/palindromic-substrings/solution/647java-bao-li-dpzhong-xin-kuo-zhan-xiang-jie-by-u/
    public int countSubstrings(String s) {
        int r = 0;
        char[] chars = s.toCharArray();
        int length = chars.length;
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = i; j >= 0; j--) {
                if (chars[i] == chars[j] && (i - j < 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    r++;
                }
            }
        }
        return r;
    }

    // 中心扩展法
    public int countSubstrings1(String s) {
        int r = 0;
        int stringLength = s.length();
        int centerCount = 2 * stringLength - 1;
        for (int center = 0; center < centerCount; center++) {
            int left = center / 2;
            int right = left + center % 2;
            while (left >=0 && right < stringLength && s.charAt(left) == s.charAt(right)) {
                r++;
                left--;
                right++;
            }
        }
        return r;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
  