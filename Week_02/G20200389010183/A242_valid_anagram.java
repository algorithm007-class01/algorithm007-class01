package com.szp.leetcode.q201_250;

public class A239_valid_anagram {
    class Solution {
        public boolean isAnagram(String s, String t) {
            if(null == s && null != t)
                return false;
            if(null == t && null != s)
                return false;
            if(s.length() != t.length())
                return false;
            int[] charCountS = new int[26];
            int[] charCountT = new int[26];
            for (int i = 0; i < s.length(); i++) {
                charCountS[s.charAt(i)-'a'] += 1;
                charCountT[t.charAt(i)-'a'] += 1;
            }
            for (int i = 0; i < 26; i++) {
                if(charCountS[i] != charCountT[i]) {
                    return false;
                }
            }
            return true;
        }
    }
/*
* 示例 1:

输入: s = "anagram", t = "nagaram"
输出: true
示例 2:

输入: s = "rat", t = "car"
输出: false

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-anagram
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
    public static void main(String[] args) {
        Solution solution = new A239_valid_anagram().new Solution();
        System.out.println(solution.isAnagram("anagram", "nagaram"));
        System.out.println("*******************");
        System.out.println(solution.isAnagram("rat", "car"));
        System.out.println("*******************");
        System.out.println(solution.isAnagram("ba", "ab"));
    }
}
