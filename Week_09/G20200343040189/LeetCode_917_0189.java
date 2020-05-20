//给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
//
// 提示：
//
// S.length <= 100
// 33 <= S[i].ASCIIcode <= 122
// S 中不包含 \ or "
//
// Related Topics 字符串


//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public String reverseOnlyLetters(String S) {
        // 将字符转转化为字符数组
        char[] ch = S.toCharArray();
        // 设置左右指针
        int i = 0, j = ch.length - 1;
        while (i < j) {
            // 碰到非字母时
            while (i < j && (ch[i] > 'z' || ch[i] < 'A' ||
                    (ch[i] > 'Z' && ch[i] < 'a'))) {
                i++;
            }
            while (i < j && (ch[j] > 'z' || ch[j] < 'A' ||
                    (ch[j] > 'Z' && ch[j] < 'a'))) {
                j--;
            }
            // 碰到字母时
            if (i < j) {
                // 左右指针指向的字母做异或操作
                ch[i] ^= ch[j];
                ch[j] ^= ch[i];
                ch[i++] ^= ch[j--];
            }
        }
        return String.valueOf(ch);
    }
}

//leetcode submit region end(Prohibit modification and deletion)
