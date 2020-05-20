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


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int len = 0;
    int left = 0;

    public String longestPalindrome(String s) {
        if (s == null) return null;
        int size = s.length();
        if (size < 2) return s;
        for (int i = 0; i < size; ++i) {
            solve(s, i, i);
            solve(s, i, i + 1);
        }
        return s.substring(left, left + len);
    }

    private void solve(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        l++;
        r--;
        if (len < r - l + 1) {
            len = r - l + 1;
            left = l;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
