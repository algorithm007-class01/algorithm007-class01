import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 49. 字母异位词分组
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
    [
        ["ate","eat","tea"],
        ["nat","tan"],
        ["bat"]
    ]
 * 第一种做法：
 *      异位词排序后，是相同的，
 *      所以可以每个单词排序后放入同一个分组，
 *      即相同排序的单词存入 map 的 key 对应的 list 中
 * 执行时间： 6 ms
 * 复杂度分析：
 *  1. 时间复杂度：O(NKlogK)，其中 N 是 strs 的长度，而 K 是 strs 中字符串的最大长度。
 *     当我们遍历每个字符串时，外部循环具有的复杂度为 O(N).然后，我们在 O(KlogK) 的时间内
 *     对每个字符排序。
 *  2. 空间复杂度：O(NK)，排序存储在 map 中的全部信息内容
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<List<String>>();
        }

        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] ca = str.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(str);
        }
        
        return new ArrayList<List<String>>(map.values());
    }
}