import java.util.*;

class LeetCode_49_0201 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String item : strs) {
            char[] charArr = item.toCharArray();
            Arrays.sort(charArr);
            String key = new String(charArr);
            if (map.containsKey(key)) {
                List<String> list = map.get(key);
                list.add(item);
            } else {
                List<String> list = new LinkedList<>();
                list.add(item);
                map.put(key, list);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (Map.Entry item : map.entrySet()) {
            res.add((List<String>) item.getValue());
        }
        return res;
    }
}