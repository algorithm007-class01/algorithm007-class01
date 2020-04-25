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
        // 只包含数字的非空字符串
        char[] chars = s.toCharArray();
        int[] r = new int[chars.length];
        if (chars.length <= 0){
            return 0;
        }
        if (chars[0] == '0'){
            return 0;
        }
        r[0] = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i-1] == '1'){
                if (chars[i] == '0') {
                    r[i] = (i==1 ? 1 : r[i-2]);
                }else {
                    r[i] = r[i-1] + (i==1 ? 1 : r[i-2]);
                }
            }else if (chars[i-1] == '2') {
                if (chars[i] >= '1' && chars[i] <= '6'){
                    r[i] = r[i-1] + (i==1 ? 1 : r[i-2]);
                }else if (chars[i] == '0') {
                    r[i] = (i==1 ? 1 : r[i-2]);
                }else {
                    r[i] = r[i-1];
                }
            }else {
                if (chars[i] == '0'){
                    return 0;
                }else {
                    r[i] = r[i-1];
                }
            }
        }
        return r[chars.length-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
