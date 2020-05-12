package week8.homework;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * <p>
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */
public class leetCode_242_0227 {
    //method1暴力解法
    public boolean isAnagram(String s, String t) {
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(t1);
        return Arrays.equals(s1, t1);
    }

    /**
     * method2 使用map
     *
     * @param s
     * @param t
     * @return
     */
    public boolean method2(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length; i++) {
            if (map.containsKey(s1[i])) {
                map.put(s1[i], map.get(s1[i]) + 1);
            } else {
                map.put(s1[i], 1);
            }
        }
        for (int i = 0; i < t1.length; i++) {
            if (map.containsKey(t1[i])) {
                map.put(t1[i], map.get(t1[i]) - 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) return false;
        }
        return true;
    }

    /**
     * method2 使用数组
     *
     * @param s
     * @param t
     * @return
     */
    public boolean method3(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        int[] arr = new int[255];
        for (int i = 0; i < s1.length; i++) {
            if (arr[s1[i]] != 0) {
                arr[s1[i]] = arr[s1[i]] + 1;
            } else {
                arr[s1[i]] = 1;
            }
        }
        for (int i = 0; i < t1.length; i++) {
            if (arr[t1[i]] != 0) {
                arr[s1[i]] = arr[s1[i]] - 1;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) return false;
        }
        return true;
    }

    /**
     * 更加简洁,但是效率其实是不高的，相比method3的写法，
     * @param s
     * @param t
     * @return
     */
    public boolean simplifyMethod(String s, String t) {
        if (s.length() != t.length()) return false;
        //因为就26个字母
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            arr[t.charAt(i) - 'a']--;
            if (arr[t.charAt(i)-'a'] < 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        boolean b = new leetCode_242_0227().method3("anagram", "nagaram");
        System.out.println(b);
    }
}
