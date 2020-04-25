//给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。 
//
// 示例 1: 
//
// 
//输入: "abc"
//输出: 3
//解释: 三个回文子串: "a", "b", "c".
// 
//
// 示例 2: 
//
// 
//输入: "aaa"
//输出: 6
//说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
// 
//
// 注意: 
//
// 
// 输入的字符串长度不会超过1000。 
// 
// Related Topics 字符串 动态规划

  
package com.dxm.leetcode.editor.cn;
public class PalindromicSubstrings{
    public static void main(String[] args) {
        Solution solution = new PalindromicSubstrings().new Solution();
      }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countSubstrings(String s) {
        char[] c = s.toCharArray();
        int len = c.length;
        int[][] dp = new int[len][len];
        int ans = 0;
        for(int l = 1; l <= len; l++)
        {
            for(int i = 0; i+l-1 < len; i++)
            {
                int j = i + l - 1;
                if(c[i] == c[j] && (j-i <= 2 || dp[i+1][j-1] == 1))
                {
                    dp[i][j] = 1;
                    ans++;
                }
            }
        }
        return ans;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}