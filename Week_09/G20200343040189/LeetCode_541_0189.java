//给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
//
// 如果剩余字符少于 k 个，则将剩余字符全部反转。
// 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
//
// 提示：
//
//
// 该字符串只包含小写英文字母。
// 给定字符串的长度和 k 在 [1, 10000] 范围内。
//
// Related Topics 字符串


//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    private void reverse(char[] s, int start, int end) {
        while (start < end) {
            char ch = s[start];
            s[start] = s[end];
            s[end] = ch;
            start++;
            end--;
        }
    }

    public String reverseStr(String s, int k) {
        // String对象在Java中是不可变的
        if (s.length() < 2 || k == 1) {
            return s;
        }
        // 将字符串转换为数组
        char[] ch = s.toCharArray();
        int len = ch.length;
        if (len <= k) {
            reverse(ch, 0, len - 1);
            return String.valueOf(ch);
        }
        for (int i = 0; i < len; i += k * 2) {
            if (i + k <= len) {
                reverse(ch, i, i + k - 1);
            } else {
                reverse(ch, i, len - 1);
            }
        }
        return String.valueOf(ch);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
