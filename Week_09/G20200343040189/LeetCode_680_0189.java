//给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
//
// 注意:
//
//
// 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
//
// Related Topics 字符串


//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    private boolean isValid(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public boolean validPalindrome(String s) {
        // 利用左右双指针
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return isValid(s, i + 1, j) || isValid(s, i, j - 1);
            }
            i++;
            j--;
        }
        return true;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
