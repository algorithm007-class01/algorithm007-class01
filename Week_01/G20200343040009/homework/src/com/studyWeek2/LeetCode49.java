package com.studyWeek2;

import java.util.*;

/**
 * 利用相同字母的特性，生成Unioncode在转为相同的key进行分类即可。
 */
public class LeetCode49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            int[] arr = new int[26];
            // 生成key
            for (int i = 0; i < s.length(); i++){
                arr[s.charAt(i) - 'a']++;
            }
            String key = Arrays.toString(arr);
            List<String> tempList = map.getOrDefault(key, new LinkedList<String>());
            tempList.add(s);
            map.put(key, tempList);
        }
        return new ArrayList<>(map.values());
    }
}
