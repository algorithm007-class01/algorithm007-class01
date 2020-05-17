//一条包含字母 A-Z 的消息通过以下方式进行了编码： 
//
// 'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
// 
//
// 给定一个只包含数字的非空字符串，请计算解码方法的总数。 
//
// 示例 1: 
//
// 输入: "12"
//输出: 2
//解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
// 
//
// 示例 2: 
//
// 输入: "226"
//输出: 3
//解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
// 
// Related Topics 字符串 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        int size = chars.length;
        if (chars[0] == '0') return 0;
        int curr = 1;
        int prev = 1;
        for (int i = 1; i < size; ++i) {
            if (chars[i] == '0' && (chars[i - 1] == '1' || chars[i - 1] == '2')) {
                int temp = curr;
                curr = prev;
                prev = curr;
            } else if (chars[i] == '0' && (chars[i - 1] == '0' || chars[i - 1] > '2'))
                return 0;
            else if (chars[i - 1] == '1' || (chars[i - 1] == '2' && chars[i] < '7'))
                curr = prev + (prev = curr);
            else
                curr = (prev = curr);
        }
        return curr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
