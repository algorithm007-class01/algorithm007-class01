//给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。 
//
// 
// 如果剩余字符少于 k 个，则将剩余字符全部反转。 
// 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。 
// 
//
// 
//
// 示例: 
//
// 输入: s = "abcdefg", k = 2
//输出: "bacdfeg"
// 
//
// 
//
// 提示： 
//
// 
// 该字符串只包含小写英文字母。 
// 给定字符串的长度和 k 在 [1, 10000] 范围内。 
// 
// Related Topics 字符串

package leetcode.editor.cn;

// 541. 反转字符串 II
public class ReverseStringIi_541 {

    //public static void main(String[] args) {
    //    Solution solution = new ReverseStringIi_541().new Solution();
    //    System.out.println(solution);
    //}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        int count = length / k / 2;
        for (int i = 0; i < count; i++) {
            int start = 2 * k * i;
            reverseString(chars, start, start + k - 1);
        }

        int remainStart = 2 * k * count;
        if (remainStart < length) {
            int remainEnd = Math.min(length, remainStart + k);
            reverseString(chars, remainStart, remainEnd - 1);
        }

        return String.valueOf(chars);
    }
    private void reverseString(char[] chars, int start, int end) {
        char temp;
        while (true) {
            if (start >= end) {
                return;
            }
            temp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = temp;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
