//给定两个字符串 s 和 t，判断它们是否是同构的。
//
// 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
//
// 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
//
// 说明:
//你可以假设 s 和 t 具有相同的长度。
// Related Topics 哈希表


//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public boolean isIsomorphic(String s, String t) {
        return canMap(s, t) && canMap(t, s);
    }

    private boolean canMap(String s, String t) {
        // ascii码共128个
        int[] map = new int[128];
        // 将字符串转化为字符数组
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        for (int i = 0; i < s1.length; i++) {
            // 如果map[s1]不存在，就将s1映射到t1
            // 如果map[s1]存在，判断map[s1]是否等于t1
            // 验证映射与其字母是否相等
            if (map[s1[i]] == 0) {
                map[s1[i]] = t1[i];
            } else if (map[s1[i]] != t1[i]) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
