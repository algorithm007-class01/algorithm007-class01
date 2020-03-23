import java.util.*;

class LeetCode_49_0179 {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs.length <= 0) {
            return res;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = String.valueOf(chars);
            List<String> list = map.get(s);
            if (list == null || list.size() < 0) {
                List<String> itemList = new ArrayList<>();
                itemList.add(str);
                map.put(s, itemList);
            } else {
                list.add(str);
                map.put(s, list);
            }
        }
        for (List<String> item : map.values()) {
            res.add(item);
        }
        return res;
    }

}