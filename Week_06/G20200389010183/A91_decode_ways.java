package com.szp.leetcode.q51_100;

//一条包含字母 A-Z 的消息通过以下方式进行了编码：
//
//'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
//给定一个只包含数字的非空字符串，请计算解码方法的总数。
//
//示例 1:
//
//输入: "12"
//输出: 2
//解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
//示例 2:
//
//输入: "226"
//输出: 3
//解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
public class A91_decode_ways {
    class Solution {
        public int numDecodings(String s) {
            if (null == s || s.length() == 0)
                return 0;
            char[] chars = s.toCharArray();
            if (chars[0] == '0')
                return 0;
            int cur = 1, pre = 1;
            for (int i = 1; i < s.length(); i++) {
                int tmp = cur;
                if (chars[i] == '0') {
                    if (chars[i - 1] == '1' || chars[i - 1] == '2')
                        cur = pre;
                    else
                        return 0;
                } else if (chars[i - 1] == '1' || (chars[i - 1] == '2' && chars[i] <= '6')) {
                    cur = cur + pre;
                }
                pre = tmp;
            }
            return cur;
        }

        private int decode(String s) {
            if (null == s || s.length() == 0)
                return 0;
            if (s.length() == 1)
                return 1;
            String two = s.substring(0, 2);
            if (s.charAt(0) == '0')
                return 0;
            if (Integer.parseInt(two) <= 26)
                return decode(s.substring(1)) + decode(s.substring(2));
            return decode(s.substring(1));
        }

        private int dp(String s) {
            if (null == s || s.length() == 0)
                return 0;
            if (s.charAt(0) == '0')
                return 0;
            int len = s.length();
            int[] dp = new int[len + 1];
            dp[len - 1] = 1;
            dp[len] = 1;
            for (int i = len - 2; i >= 0; i--) {
                if (s.charAt(i + 1) == '0') {
                    if (s.charAt(i) == '1' || s.charAt(i) == '2')
                        dp[i] = dp[i + 2];
                    else
                        return 0;
                }
                else {
                    String two = s.substring(i, i + 2);
                    if (Integer.parseInt(two) <= 26) {
                        dp[i] = dp[i + 1] + dp[i + 2];
                    } else {
                        dp[i] = dp[i + 1];
                    }
                }
            }
            return dp[0];
        }

    }

    public static void main(String[] args) {
        Solution solution = new A91_decode_ways().new Solution();
        System.out.println(solution.numDecodings("12"));
        System.out.println(solution.numDecodings("226"));
        System.out.println(solution.numDecodings("20"));
        System.out.println(solution.numDecodings("0"));

        System.out.println(solution.dp("12"));
        System.out.println(solution.dp("226"));
        System.out.println(solution.dp("20"));
        System.out.println(solution.dp("0"));
//        System.out.println("12".substring(0,2));
    }
}
