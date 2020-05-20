/**
 * 151. 翻转字符串里的单词
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * 
 * 示例 1：
    输入: "the sky is blue"
    输出: "blue is sky the"

   示例 2：
    输入: "  hello world!  "
    输出: "world! hello"
    解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。

   示例 3：
    输入: "a good   example"
    输出: "example good a"
    解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 
 * 复杂度分析
    时间复杂度：O(N)，其中 N 为输入字符串的长度。

    空间复杂度：Java 和 Python 的方法需要 O(N) 的空间来存储字符串，而 C++ 方法只需要 O(1) 的额外空间来存放若干变量。
 */
class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = trimSpaces(s);

        reverse(sb, 0, sb.length() - 1);
        reverseEachWord(sb);

        return sb.toString();
    }

    public StringBuilder trimSpaces(String s) {
        int left = 0, right = s.length() - 1;
        while (left <= right && s.charAt(left) == ' ') ++left;
        while (left <= right && s.charAt(right) == ' ') --right;
        StringBuilder sb = new StringBuilder();
        while (left <= right)  {
            char c = s.charAt(left);

            if (c != ' ') {
                sb.append(c);
            } else if (sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }

            ++left;
        }
        return sb;
    }

    public void reverse (StringBuilder sb, int left, int right) {
        while (left < right) {
            char tmp = sb.charAt(left);
            sb.setCharAt(left++, sb.charAt(right));
            sb.setCharAt(right--, tmp);
        }
    }

    public void reverseEachWord(StringBuilder sb) {
        int n = sb.length();
        int start = 0, end = 0;
        while (start < n) {
            while (end < n && sb.charAt(end)!=' ') ++end;
            reverse(sb, start, end - 1);
            start = end + 1;
            ++end;
        }
    }
}