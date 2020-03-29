import java.util.*;

/**
 * 49. 字母异位词分组
 * https://leetcode-cn.com/problems/group-anagrams/
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0)
            return new ArrayList();

        // 字序排列的字符串关系映射
        Map<String, List> sortStrMap = new HashMap<String, List>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            //chars to str ==> key
            String sortStr = String.valueOf(chars);

            if (!sortStrMap.containsKey(sortStr))
                sortStrMap.put(sortStr, new ArrayList());

            sortStrMap.get(sortStr).add(str);
        }

        return new ArrayList(sortStrMap.values());
    }
}
