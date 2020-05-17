package cxl.study.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 387. 字符串中的第一个唯一字符
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 */
public class LeetCode_387_FirstUniqueCharacterInAString {

    public int firstUniqueChar(String s) {
        Map<Character, Integer> countResult = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            int countInStr = countResult.getOrDefault(c,0);
            countResult.put(c,++countInStr);
        }
        for (int i = 0; i < chars.length; i++) {
            if (countResult.get(chars[i]) == 1) {
                return i;
            }
        }
        return -1;
    }

}
