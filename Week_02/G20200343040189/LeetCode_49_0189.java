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

import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //构造一个HashMap，字符串是键，数组列表是值
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        //对输入的字符串进行遍历
        for (String s : strs) {
            //将输入的字符串转化为数组
            char[] ch = s.toCharArray();
            //对数组进行排序
            Arrays.sort(ch);
            //排序后的数组作为键
            String key = String.valueOf(ch);
            if (!map.containsKey(key)) {
                //向Map中添加不存在的键
                map.put(key, new ArrayList<>());
            }
            //将s加入到数组列表中
            map.get(key).add(s);
        }
        return new ArrayList(map.values());
    }
}
//leetcode submit region end(Prohibit modification and deletion)
