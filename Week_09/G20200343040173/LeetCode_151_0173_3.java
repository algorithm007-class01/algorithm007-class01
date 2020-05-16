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
    空间复杂度：O(N)，双端队列存储单词需要 O(N) 的空间。
 */
class Solution {
    public String reverseWords(String s) {
        
        // 去掉开头空白字符
        while (left <= right && s.charAt(left) == ' ') ++left;
        // 去掉末尾空白字符
        while (left <= right && s.charAt(right) == ' ') --right;

        Deque<String> d = new ArrayDeque<>();
        StringBuilder word = new StringBuilder();

        while (left <= right) {
            char c = s.charAt(left);
            if ((word.length() != 0) && (c == ' ')) {
                // 将单词 push 到队列的头部
                d.offerFirst(word.toString());
                word.setLength(0);
            } else if (c != ' ') {
                word.append(c);
            }
            ++left;
        }
        d.offerFirst(word.toString());

        return String.join(" ", d);
    }
}