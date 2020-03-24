//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串


import java.util.List;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();

        for (String str : strs){
            String indexString = getIndexString1(str);
            List<String> strings = map.computeIfAbsent(indexString, k -> new ArrayList<>());
            strings.add(str);
        }
        return new ArrayList<>(map.values());
    }

    private String getIndexString(String str){
        int[] result = new int[26];
        Arrays.fill(result,0);
        for (char c : str.toCharArray()){
            result[c-'a']++;
        }
        StringBuilder rs = new StringBuilder();
        for (int i : result){
            rs.append("#").append(i);
        }
        return rs.toString();
    }

    private String getIndexString1(String str){
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
