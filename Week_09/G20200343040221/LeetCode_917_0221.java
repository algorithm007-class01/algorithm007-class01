//给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入："ab-cd"
//输出："dc-ba"
// 
//
// 示例 2： 
//
// 输入："a-bC-dEf-ghIj"
//输出："j-Ih-gfE-dCba"
// 
//
// 示例 3： 
//
// 输入："Test1ng-Leet=code-Q!"
//输出："Qedo1ct-eeLg=ntse-T!"
// 
//
// 
//
// 提示： 
//
// 
// S.length <= 100 
// 33 <= S[i].ASCIIcode <= 122 
// S 中不包含 \ or " 
// 
// Related Topics 字符串

package leetcode.editor.cn;

// 917. 仅仅反转字母
public class ReverseOnlyLetters_917 {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseOnlyLetters(String S) {
        char[] chars = S.toCharArray();

        int i = 0;
        char[] chars1 = new char[chars.length];
        for (char ch : chars) {
            int charCode = (int) ch;
            if ((charCode >= 97 && charCode <= 122) || (charCode >= 65 && charCode <= 90)) {
                chars1[i++] = ch;
            }
        }
        reverseString(chars1, 0, i - 1);

        i = 0;
        for (int j = 0; j < chars.length; j++) {
            int charCode = (int) chars[j];
            if ((charCode >= 97 && charCode <= 122) || (charCode >= 65 && charCode <= 90)) {
                chars[j] = chars1[i++];
            }
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
