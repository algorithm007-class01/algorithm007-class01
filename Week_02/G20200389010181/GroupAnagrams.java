package demo;

import java.util.*;

/**
 * @author Bai
 */
public class GroupAnagrams {



    public static List<List<String>> test1(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            List<String> stringList = map.computeIfAbsent(key, k -> new ArrayList<>());
            stringList.add(s);
        }
        return new ArrayList<>(map.values());
    }
}
