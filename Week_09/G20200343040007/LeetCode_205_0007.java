//给定两个字符串 s 和 t，判断它们是否是同构的。 
//
// 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。 
//
// 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。 
//
// 示例 1: 
//
// 输入: s = "egg", t = "add"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "foo", t = "bar"
//输出: false 
//
// 示例 3: 
//
// 输入: s = "paper", t = "title"
//输出: true 
//
// 说明: 
//你可以假设 s 和 t 具有相同的长度。 
// Related Topics 哈希表


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] map_s = new int[128];
        int[] map_t = new int[128];
        int count_s = 1;
        int count_t = 1;
        StringBuilder sb_s = new StringBuilder();
        StringBuilder sb_t = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            if (map_s[s.charAt(i)] == 0)
                map_s[s.charAt(i)] = count_s++;
            if (map_t[t.charAt(i)] == 0)
                map_t[t.charAt(i)] = count_t++;
            sb_s.append(map_s[s.charAt(i)]);
            sb_t.append(map_t[t.charAt(i)]);
        }
        return sb_s.toString().equals(sb_t.toString());
    }
}
//leetcode submit region end(Prohibit modification and deletion)
