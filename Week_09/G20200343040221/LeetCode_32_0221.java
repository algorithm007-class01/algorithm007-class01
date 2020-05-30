//给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。 
//
// 示例 1: 
//
// 输入: "(()"
//输出: 2
//解释: 最长有效括号子串为 "()"
// 
//
// 示例 2: 
//
// 输入: ")()())"
//输出: 4
//解释: 最长有效括号子串为 "()()"
// 
// Related Topics 字符串 动态规划

package leetcode.editor.cn;

import java.util.Stack;

// 32. 最长有效括号
public class LongestValidParentheses_32 {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private final char left = '(';
    private final char right = ')';
    private final char zero = '0';

    // 动态规划
    public int longestValidParentheses(String s) {
        int length = s.length();
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return "()".equals(s) ? 2 : 0;
        }

        int max = 0;
        int[] dp = new int[length];
        char[] chars = s.toCharArray();
        for (int i = 1; i < length; i++) {
            if (chars[i] == right) {
                if (chars[i - 1] == left) {
                    dp[i] = (i - 2 < 0) ? 2 : (dp[i - 2] + 2);
                } else {
                    int leftIndex = i - dp[i - 1] - 1;
                    if (leftIndex >= 0 && chars[leftIndex] == left) {
                        if (leftIndex - 1 < 0) {
                            dp[i] = dp[i - 1] + 2;
                        } else {
                            dp[i] = dp[i - 1] + dp[leftIndex - 1] + 2;
                        }
                    }
                }

                if (max < dp[i]) {
                    max = dp[i];
                }
            }
        }
        return max;
    }

    // 基于栈
    public int longestValidParentheses1(String s) {
        int max = 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == left) {
                stack.push(i);
            } else {
                stack.pop();

                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }

    // 暴力破解：O(n平方)
    public int longestValidParentheses2(String s) {
        char[] chars = s.toCharArray();
        while (true) {
            boolean hasMatch = false;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == left) {
                    int matchIndex = -1;
                    for (int j = i + 1; j < chars.length; j++) {
                        if (chars[j] == left) {
                            break;
                        }
                        if (chars[j] == right) {
                            matchIndex = j;
                            break;
                        }
                    }
                    if (matchIndex != -1) {
                        chars[i] = chars[matchIndex] = zero;
                        hasMatch = true;
                    }
                }
            }
            if (!hasMatch) {
                break;
            }
        }

        int max = 0;
        int counter = 0;
        for (char ch : chars) {
            if (ch == left || ch == right) {
                max = Math.max(max, counter);
                counter = 0;
            } else {
                counter += 1;
            }
        }
        max = Math.max(max, counter);
        
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
