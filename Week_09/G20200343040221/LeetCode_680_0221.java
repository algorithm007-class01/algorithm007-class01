//给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。 
//
// 示例 1: 
//
// 
//输入: "aba"
//输出: True
// 
//
// 示例 2: 
//
// 
//输入: "abca"
//输出: True
//解释: 你可以删除c字符。
// 
//
// 注意: 
//
// 
// 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。 
// 
// Related Topics 字符串

package leetcode.editor.cn;

// 680. 验证回文字符串 Ⅱ
public class ValidPalindromeIi_680 {

    //public static void main(String[] args) {
    //    Solution solution = new ValidPalindromeIi_680().new Solution();
    //    System.out.println(solution);
    //}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validPalindrome(String s) {
        int length = s.length();
        if (length <= 2) {
            return true;
        }

        int start = 0;
        int end = length - 1;
        for (; start < end; start++, end--) {
            if (s.charAt(start) != s.charAt(end)) {
                return isPalindrome(s, start + 1, end) || isPalindrome(s, start, end - 1);
            }
        }
        return true;
    }

    private boolean isPalindrome(String s, int start, int end) {
        for (; start < end; start++, end--) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
