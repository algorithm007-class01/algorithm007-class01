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
 * 第二种做法：
 *    根据每个单词中字母出现的次数来分组
 * 执行时间： 19 ms
 * 复杂度分析：
 *  1. 时间复杂度：O(NK)，其中 N 是 strs 的长度，而 K 是 strs 中字符串的最大长度。
 *      计算每个字符串的字符串大小是线性的，我们统计每个字符串。
 *  2. 空间复杂度：O(NK)，排序存储在 map 中的全部信息内容
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<List<String>>();
        }

        HashMap<String, List<String>> map = new HashMap<String, List<String>>();

        for (String str : strs) {
            String key = combieKey(str);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }

            map.get(key).add(str);
        }

        return new ArrayList<List<String>>(map.values());
    }

    private String combieKey (String str) {
        String key = "";

        int[] counts = new int[26];
        Arrays.fill(counts, 0);
        
        for (char c : str.toCharArray()) {
            counts[c - 'a']++;
        }

        StringBuffer sb = new StringBuffer("");

        for (int i = 0; i < 26; i++) {
            sb.append("#");
            sb.append(counts[i]);
        }

        key = sb.toString();

        return key;
    }
}