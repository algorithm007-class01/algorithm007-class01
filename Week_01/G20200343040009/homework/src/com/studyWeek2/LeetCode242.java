package com.studyWeek2;

/**
 * 1. 长度不等，false
 * 2. 若相等，初始化26个字母表的hash表，遍历s、t字符串
 * 3. 利用一个计数器做加减
 */
public class LeetCode242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
