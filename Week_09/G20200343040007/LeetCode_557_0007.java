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


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int size = chars.length;
        int index = 0;
        while (index < size) {
            int temp = index;
            while (temp < size && chars[temp] != ' ') temp++;
            reverse(index, temp - 1, chars);
            index = temp + 1;
        }
        return String.valueOf(chars);
    }

    private void reverse(int l, int r, char[] chars) {
        while (l < r) {
            char c = chars[l];
            chars[l++] = chars[r];
            chars[r--] = c;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
