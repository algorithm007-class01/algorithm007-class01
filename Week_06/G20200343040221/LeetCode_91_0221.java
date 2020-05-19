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

package leetcode.editor.cn;

public class DecodeWays_91 {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private final char char0 = '0';
    private final char char1 = '1';
    private final char char2 = '2';
    private final char char6 = '6';

    // 动态规划 - 状态压缩
    public int numDecodings(String s) {
        int len = s.length();
        int r2 = 1;
        int r1 = s.charAt(len - 1) == char0 ? 0 : 1;;
        for (int i = len - 2; i >= 0; i--) {
            int temp = r1;
            char currChar = s.charAt(i);
            char nextChar = s.charAt(i + 1);
            if (currChar == char0) {
                r1 = 0;
            } else if (currChar == char1) {
                r1 = temp + r2;
            } else if (currChar == char2 && nextChar <= char6) {
                r1 = temp + r2;
            } else {
                r1 = temp;
            }
            r2 = temp;
        }
        return r1;
    }

    // 动态规划：f(i) = s[i] + s[i + 1] <= 26 ? (f(i + 1) + f(i + 2)) : f(i + 1)
    // 参考：https://leetcode-cn.com/problems/decode-ways/solution/java-di-gui-dong-tai-gui-hua-kong-jian-ya-suo-by-r/
    public int numDecodings1(String s) {
        int len = s.length();
        int dp[] = new int[len + 1];
        dp[len] = 1;
        dp[len - 1] = s.charAt(len - 1) == char0 ? 0 : 1;
        for (int i = len - 2; i >= 0; i--) {
            char currChar = s.charAt(i);
            char nextChar = s.charAt(i + 1);
            if (currChar == char0) {
                dp[i] = 0;
            } else if (currChar == char1) {
                dp[i] = dp[i + 1] + dp[i + 2];
            } else if (currChar == char2 && nextChar <= char6) {
                dp[i] = dp[i + 1] + dp[i + 2];
            } else {
                dp[i] =  dp[i + 1];
            }
        }
        return dp[0];
    }

    // 递归
    public int numDecodings2(String s) {
        return numDecodings(s, 0);
    }
    private int numDecodings(String s, int start) {
        int len = s.length();
        if (len == start) {
            return 1;
        }

        char currChar = s.charAt(start);
        if (currChar == char0) {
            return 0;
        }

        int r1 = numDecodings(s, start + 1);
        int r2 = 0;
        if (start < len - 1) {
            if (currChar == char1) {
                r2 = numDecodings(s, start + 2);
            } else if (currChar == char2 && s.charAt(start + 1) <= char6) {
                r2 = numDecodings(s, start + 2);
            }
        }

        return r1 + r2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
  