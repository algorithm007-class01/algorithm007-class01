package G20200343040221;

import java.util.*;

/**
 * 这段时间比较忙，为了交作业，题目解法完全拷贝Leecode上他人的代码，后面有时间自己再学习
 */
public class LeetCode_49_0211 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }

}
