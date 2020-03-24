package leetcode;

import java.util.*;

public class LeetCode_49_0223 {

    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for(String s:strs){
            char[] sc = s.toCharArray();
            Arrays.sort(sc);
            String sortedStr = String.valueOf(sc);
            if(!map.containsKey(sortedStr)) {
                map.put(sortedStr,new ArrayList());
            }
            map.get(sortedStr).add(s);
        }
        return new ArrayList(map.values());
    }
}
