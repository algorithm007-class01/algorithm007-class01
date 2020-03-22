package week2.homework;

import java.util.*;

/**
 * 49. 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * 说明：
 * <p>
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 */
public class LeetCode_49_0227 {

    public List<List<String>> groupAnagrams(String[] strs) {
//        return method1(strs);
//        return method2(strs);
        return method3(strs);
    }


    /**
     * 基础解法，效率太慢，容易理解，但是可以满足各种数据格式
     *
     * @param strs
     * @return
     */
    private List<List<String>> method1(String[] strs) {
        List<List<String>> rs = new ArrayList<>();
        HashMap<Integer, String> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            map.put(i, strs[i]);
        }
        for (int i = 0; i < strs.length; i++) {
            if (!map.containsKey(i)) continue;
            List<String> list = new ArrayList<>();
            list.add(strs[i]);
            for (int j = i + 1; j < strs.length; j++) {
                if (isAnagrams(strs[i], strs[j])) {
                    list.add(strs[j]);
                    map.remove(j);
                }
            }
            rs.add(list);
        }
        return rs;
    }

    /**
     * 排序解法
     *
     * @param strs
     * @return
     */
    private List<List<String>> method2(String[] strs) {
        Map<String, List<String>> map = new HashMap();
        for (int i = 0; i < strs.length; i++) {
            char[] toSortArr = strs[i].toCharArray();
            Arrays.sort(toSortArr);
            String key = String.valueOf(toSortArr);
            if (map.containsKey(key)) {
                map.get(key).add(strs[i]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(key, list);
            }
        }
        return new ArrayList<>(map.values());
    }

    /**
     * 算术基本定理，将字符串映射到成一个数字，真的是很好的思维
     * * https://leetcode-cn.com/problems/group-anagrams/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--16/ 原贴
     * *
     * * @param strs
     * * @return
     */
    private List<List<String>> method3(String[] strs) {
        Map<Integer, List<String>> map = new HashMap();
        int[] prim = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};
        for (int i = 0; i < strs.length; i++) {
            int key = 1;
            String str = strs[i];
            for (int j = 0; j < str.length(); j++) {
                key *= str.charAt(i) - 'a' * prim[i];
            }
            if (map.containsKey(key)) {
                map.get(key).add(strs[i]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(key, list);
            }
        }
        return new ArrayList<>(map.values());
    }

    /**
     * 判断是否是字母异位词
     *
     * @param t1
     * @param t2
     * @return
     */
    public boolean isAnagrams(String t1, String t2) {
        if (t1.length() != t2.length()) return false;
        int[] arr = new int[26];
        for (int i = 0; i < t1.length(); i++) {
            arr[t1.charAt(i) - 'a']++;
            arr[t2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) return false;
        }
        return true;
    }
}
