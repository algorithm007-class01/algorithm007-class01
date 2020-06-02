//给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。 
//
// 示例 1: 
//
// 
//输入: "Let's take LeetCode contest"
//输出: "s'teL ekat edoCteeL tsetnoc" 
// 
//
// 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。 
// Related Topics 字符串

package leetcode.editor.cn;

// 557. 反转字符串中的单词 III
public class ReverseWordsInAStringIii_557 {

    //public static void main(String[] args) {
    //    Solution solution = new ReverseWordsInAStringIii_557().new Solution();
    //    System.out.println(solution);
    //}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {
        int start = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                reverseString(chars, start, i - 1);
                start = i + 1;
            }
        }
        reverseString(chars, start, chars.length - 1);
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
