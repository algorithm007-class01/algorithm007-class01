import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 *
 * https://leetcode-cn.com/problems/group-anagrams/description/
 *
 * algorithms
 * Medium (61.12%)
 * Likes:    291
 * Dislikes: 0
 * Total Accepted:    58.5K
 * Total Submissions: 95.5K
 * Testcase Example:  '["eat","tea","tan","ate","nat","bat"]'
 *
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 
 * 示例:
 * 
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ⁠ ["ate","eat","tea"],
 * ⁠ ["nat","tan"],
 * ⁠ ["bat"]
 * ]
 * 
 * 说明：
 * 
 * 
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        char[] a_z = new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            int[] chars = new int[26];
            for (int j = 0; j < str.length(); j++) {
                chars[str.charAt(j) - 'a']++;
            }
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < chars.length; j++) {
                for (int x = 0; x < chars[j]; x++) {
                    builder.append(a_z[j]);
                }
            }

            String key = builder.toString();
            List<String> strs1 = map.get(key);
            if (null == strs1) {
                strs1 = new ArrayList<>();
                map.put(key, strs1);
            }
            strs1.add(str);
        }
        return new ArrayList<>(map.values());
    }
}
// @lc code=end

