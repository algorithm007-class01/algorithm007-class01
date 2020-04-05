import java.util.*;

public class LeetCode_49_0241 {

    /*给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

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

    //这题自己没做出来，需要多刷几遍
    /*第一种解法  排序数组分类
    复杂度分析

    时间复杂度：O(NK \log K)O(NKlogK)，其中 NN 是 strs 的长度，而 KK 是 strs 中字符串的最大长度。当我们遍历每个字符串时，外部循环具有的复杂度为 O(N)O(N)。然后，我们在 O(K \log K)O(KlogK) 的时间内对每个字符串排序。

    空间复杂度：O(NK)O(NK)，排序存储在 ans 中的全部信息内容。*/

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

    /*第二种解法  按计数分类
    复杂度分析

    时间复杂度：O(NK)O(NK)，其中 NN 是 strs 的长度，而 KK 是 strs 中字符串的最大长度。计算每个字符串的字符串大小是线性的，我们统计每个字符串。

    空间复杂度：O(NK)O(NK)，排序存储在 ans 中的全部信息内容。*/

    public List<List<String>> groupAnagramsCopy(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }

}
