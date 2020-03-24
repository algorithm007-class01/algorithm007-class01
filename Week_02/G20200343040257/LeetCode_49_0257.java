
import java.util.*;

/**
 * 49. 字母异位词分组
 * https://leetcode-cn.com/problems/group-anagrams/
 */
public class LeetCode_49_GroupAnagrams {

    /**
     * 由于异位词字母均相同，因此将字符串排序作为Key遍历时将符合异位词条件的字符串放入Map的Value中
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> resultMap = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = String.valueOf(chars);
            List<String> stringList = resultMap.get(sortedStr);
            if (stringList == null) {
                resultMap.put(sortedStr, new ArrayList<String>() {
                    {
                        add(str);
                    }
                });
            } else {
                stringList.add(str);
            }
        }
        return new ArrayList<List<String>>(resultMap.values());
    }

}
