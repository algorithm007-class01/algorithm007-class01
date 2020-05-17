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


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseOnlyLetters(String S) {
        char[] chars = S.toCharArray();
        int size = chars.length;
        int l = 0, r = size - 1;
        while (l < r) {
            while (l < size && symbol(chars[l])) l++;
            while (r >= 0 && symbol(chars[r])) r--;
            if (l < r)
                swap(l++, r--, chars);
            else
                break;
        }
        return String.valueOf(chars);
    }

    private boolean symbol(char c) {
        int a = c - 'a';
        int b = c - 'A';
        if ((a >= 0 && a < 26) || (b >= 0 && b < 26))
            return false;
        else return true;
    }

    private void swap(int l, int r, char[] chars) {
        chars[l] ^= chars[r];
        chars[r] ^= chars[l];
        chars[l] ^= chars[r];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
