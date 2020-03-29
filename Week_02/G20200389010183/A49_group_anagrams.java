package com.szp.leetcode.q1_50;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class A49_group_anagrams {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            if(null == strs || strs.length == 0)
                return new ArrayList<>();
            Map<String, List<String>> map = new HashMap<>();
            List<List<String>> res = new ArrayList<>();
            for (String str : strs) {
                boolean matched = false;
                for(Map.Entry entry :map.entrySet()){
                    String key = (String)entry.getKey();
                    if(isAnagrams(str,key)){
                        List<String> list = (List<String>) entry.getValue();
                        list.add(str);
                        matched = true;
                        break;
                    }
                }
                if(!matched){
                    List<String> list = new ArrayList<>();
                    list.add(str);
                    map.put(str, list);
                    res.add(list);
                }
            }
            return res;
        }

        public boolean isAnagrams(String str, String key) {
            if(null == str && null != key)
                return false;
            if(null == key && null != str)
                return false;
            if(null == str && null == key)
                return true;
            if(str.length() != key.length())
                return false;

            int len = key.length();
            int[] countStr = new int[26];
            int[] countKey = new int[26];

            for (int i = 0; i< len; i++) {
                char c1 = str.charAt(i);
                char c2 = key.charAt(i);
                countStr[c1-'a'] = countStr[c1-'a'] + 1;
                countKey[c2-'a'] = countKey[c2-'a'] + 1;
            }
            for (int i = 0; i < 26; i++) {
                if(countKey[i] != countStr[i])
                    return false;
            }
            return true;
        }
    }

    /*    给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
        示例:
        输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
        输出:
                [
                ["ate","eat","tea"],
                ["nat","tan"],
                ["bat"]
                ]
        说明：
        所有输入均为小写字母。
        不考虑答案输出的顺序。*/
    public static void main(String[] args) {

        Solution solution = new A49_group_anagrams().new Solution();
        System.out.println(solution.isAnagrams("ate", "eat"));
        System.out.println(solution.isAnagrams("ate", "ant"));
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = solution.groupAnagrams(strs);
        System.out.println(res.size());
        for (List<String> list : res) {
            System.out.println("************");
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}
